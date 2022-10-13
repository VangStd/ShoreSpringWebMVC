/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entity.CustomerEntity;
import com.java.service.CustomerService;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/profile-user")
    public String changeProflie(Model model, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("userSession") != null) {
            String UserName = (String) httpSession.getAttribute("userSession");
            long CusID = customerService.getIdByUserName(UserName);
            CustomerEntity customer = customerService.findById(CusID);
            model.addAttribute("customer", customer);
            return "profile";
        } else {
            return "redirect:/form-login";
        }
    }

    @PostMapping("/save-change-user")
    public String saveChangeProfile(@ModelAttribute("customer") @Valid CustomerEntity customer, BindingResult br, ModelMap modelMap) throws IOException {
        if (br.hasErrors()) {
            return "profile";
        } else {
            if (!customer.getAvatarUrl().isEmpty()) {
                cloudinary.uploader().destroy(String.valueOf(customer.getCusID()), ObjectUtils.asMap("public_id", String.valueOf(customer.getCusID()+"_"+customer.getUserName())));
                Map uploadImg = cloudinary.uploader().upload(customer.getAvatarUrl().getBytes(), ObjectUtils.asMap("public_id", String.valueOf(customer.getCusID()+"_"+customer.getUserName())));
                String urlAvatar = (String) uploadImg.get("secure_url");
                customer.setAvatar(urlAvatar);
            }
            customerService.save(customer);
            modelMap.addAttribute("ssSaveProfile", "notify save success");
            return "profile";
        }
    }

    @GetMapping("/change-password")
    public String changePassword(Model model, HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("userSession") != null) {
            String UserName = (String) httpSession.getAttribute("userSession");
            long CusID = customerService.getIdByUserName(UserName);
            CustomerEntity customer = customerService.findById(CusID);
            model.addAttribute("customer", customer);
            request.setAttribute("pass", customer.getPassWord());
            return "changepass";
        } else {
            return "redirect:/form-login";
        }
    }

    @PostMapping("/save-change-pass")
    public String saveChangePassword(@ModelAttribute("customer") CustomerEntity customer, HttpServletRequest request) {
        String yourPassword = request.getParameter("yourpass");
        String newPassword = request.getParameter("newpass");
        String cofirmPassword = request.getParameter("confirm");
        //check confirm pass
        boolean oldPass = BCrypt.checkpw(yourPassword, customer.getPassWord());
        if (!oldPass) {
            request.setAttribute("errChangePass1", "PassConfirmIncorrect");
            request.setAttribute("userpass", yourPassword);
        }
        if (!newPassword.equals(cofirmPassword)) {
            request.setAttribute("errChangePass2", "ConfirmNewPassIncorrect");
            request.setAttribute("newpass", newPassword);
            request.setAttribute("confirm", cofirmPassword);
        }
        if (oldPass && newPassword.equals(cofirmPassword)) {
            customer.setPassWord(BCrypt.hashpw(cofirmPassword, BCrypt.gensalt(10)));
            customerService.save(customer);
            request.setAttribute("ssChangePass", "notifSuccess");
            return "changepass";
        } else {
            return "changepass";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot_pass";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(HttpServletRequest request) throws MessagingException {
        String email = request.getParameter("email");
        if (customerService.checkEmail(email) == 2) {
            String Code = sendMail(email);
            customerService.updateCodeByEmail(Code, email);
            request.setAttribute("emailconfirm", email);
            return "confirm_forgot_pass";
        } else {
            request.setAttribute("errForgotpass1", "mail not exist");
        }
        return "forgot_pass";
    }

    @PostMapping("/confirm-code-forgot")
    public String confirmCode(HttpServletRequest request) {
        String email = request.getParameter("email");
        String code = request.getParameter("Code");
        if (customerService.getCountByCodeForgot(code) > 0) {
            request.setAttribute("mail", email);
            return "newpass_forgot_pass";
        } else {
            request.setAttribute("errForgotpass2", "ConfirmCodeFail");
            return "confirm_forgot_pass";
        }
    }

    @PostMapping("/save-forgot-password")
    public String updateForgotPassword(HttpServletRequest request) {
        String email = request.getParameter("email");
        String newpass = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        if (!newpass.equals(confirm)) {
            request.setAttribute("errForgotpass3", "confirmpass not correct");
            request.setAttribute("mail", email);
            return "newpass_forgot_pass";
        }
        String passHas = BCrypt.hashpw(confirm, BCrypt.gensalt(10));
        customerService.updatePasswordForgot(passHas, email);
        return "redirect:/form-login";
    }

    public String sendMail(String email) throws MessagingException {
        Random random = new Random();
        long codeforgot = random.nextInt(1000000000);
        String code = String.valueOf(codeforgot);
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); //Thay abc bằng địa chỉ người nhận

        mailMessage.setSubject("Forgot Password ! ");
        mailMessage.setText("Code : " + code);

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "dkquanga20139@cusc.ctu.edu.vn", "0984961735");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
        return code;
    }
}
