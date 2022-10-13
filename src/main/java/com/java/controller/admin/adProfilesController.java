/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entity.AdminEntity;
import com.java.service.AdminService;
import com.java.service.CustomerService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class adProfilesController {
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/admin/update-password")
    public String changePassword(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        String UserName = request.getSession().getAttribute("adminSession").toString();
        AdminEntity adminEntity = adminService.findByUserName(UserName);
        model.addAttribute("admin", adminEntity);
        return "ad_changepassword";
    }
    
    @PostMapping("/admin/update-password")
    public String changePassword(@Valid @ModelAttribute("admin") AdminEntity adminEntity, BindingResult br, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        String confirmOldPass = request.getParameter("confirmoldpass");
        boolean checkOldPass = BCrypt.checkpw(confirmOldPass, adminEntity.getPassWord());
        if (!checkOldPass) {
            model.addAttribute("ad_err_changepass_1", "confirmoldpassnotconreect");
        }
        if (!adminEntity.getNewPassword().equals(adminEntity.getConfirmNewPassword())) {
            model.addAttribute("ad_err_changepass_2", "newpassandconfirmnewnotconrrect");
        }
        if (!checkOldPass || !adminEntity.getNewPassword().equals(adminEntity.getConfirmNewPassword()) || br.hasErrors()) {
            model.addAttribute("admin", adminEntity);
            model.addAttribute("confirmold", confirmOldPass);
            model.addAttribute("newpass", adminEntity.getNewPassword());
            model.addAttribute("confirmnewpass", adminEntity.getConfirmNewPassword());
            return "ad_changepassword";
        } else {
            String newPassHash = BCrypt.hashpw(adminEntity.getConfirmNewPassword(), BCrypt.gensalt(10));
            adminEntity.setPassWord(newPassHash);
            adminService.save(adminEntity);
            request.setAttribute("notiChangpass", "notif");
            return "ad_changepassword";
        }
    }
    
    @GetMapping("/admin/admin-profile")
    public String updateProfile(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        String UserName = request.getSession().getAttribute("adminSession").toString();
        AdminEntity adminEntity = adminService.findByUserName(UserName);
        model.addAttribute("admin", adminEntity);
        return "ad_profile";
    }
    
    @PostMapping("/admin/admin-profile")
    public String updateProfile(@ModelAttribute("admin") AdminEntity adminEntity, Model model, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        if (!adminEntity.getUrlAvatar().isEmpty()) {
            cloudinary.uploader().destroy(String.valueOf(adminEntity.getID() + "__" + adminEntity.getUserName()), ObjectUtils.asMap("public_id", String.valueOf(adminEntity.getID() + "__" + adminEntity.getUserName())));
            Map uploadImg = cloudinary.uploader().upload(adminEntity.getUrlAvatar().getBytes(), ObjectUtils.asMap("public_id", String.valueOf(adminEntity.getID() + "__" + adminEntity.getUserName())));
            String url = (String) uploadImg.get("secure_url");
            adminEntity.setAvatar(url);
        }
        String oldMail = request.getParameter("mail");
        if (!oldMail.equalsIgnoreCase(adminEntity.getEmail())) {
            if (customerService.checkEmail(adminEntity.getEmail()) == 2) {
                model.addAttribute("upprofileadmin1", "mailexist");
                model.addAttribute("admin", adminEntity);
                return "ad_profile";
            }
        }
        adminService.save(adminEntity);
        model.addAttribute("noti_updateprofile1", "notiudatesuccess");
        return "ad_profile";
    }
}
