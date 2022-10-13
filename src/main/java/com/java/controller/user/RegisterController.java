/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.entity.CustomerEntity;
import com.java.service.AdminService;
import com.java.service.CustomerService;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kyqua
 */
@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/form-register")
    public String registerPage(Model model) {
        CustomerEntity customer = new CustomerEntity();
        model.addAttribute("customer", customer);
        return "register";
    }

    @PostMapping("/submit-register")
    public String submitPage( @ModelAttribute("customer")@Valid CustomerEntity customer, BindingResult br, ModelMap modelMap, @RequestParam("confirmpass") String confirmPass) {
        if (br.hasErrors()) {
            return "register";
        }
        if (!customer.getPassWord().equals(confirmPass)) {
            modelMap.addAttribute("errRegister1", "PassConfirmNotCorrect");
        }
        if (customerService.checkByUserName(customer.getUserName()) == 2 || adminService.getCountAdminByUserName(customer.getUserName()) > 0) {
            modelMap.addAttribute("errRegister2", "UsernameExist");
        }
        if (customerService.checkEmail(customer.getEmail()) == 2) {
            modelMap.addAttribute("errRegister3", "EmailExist");
        }
        if (customerService.checkByUserName(customer.getUserName()) == 2 || customerService.checkEmail(customer.getEmail()) == 2 || !customer.getPassWord().equals(confirmPass) || adminService.getCountAdminByUserName(customer.getUserName()) > 0) {
            return "register";
        } else {
            String Pass = customer.getPassWord();
            String passHas = BCrypt.hashpw(Pass, BCrypt.gensalt(10));
            customer.setPassWord(passHas);
            customerService.save(customer);
            return "redirect:/form-login";
        }
    }
}
