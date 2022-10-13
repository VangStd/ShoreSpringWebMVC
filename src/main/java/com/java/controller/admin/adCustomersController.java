/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entity.CustomerEntity;
import com.java.service.CustomerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class adCustomersController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @RequestMapping("/admin/page-customer")
    public String indexCustomer(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        } else {
            List<CustomerEntity> list = customerService.findAll();
            request.setAttribute("listCus", list);
            return "ad_customer";
        }
    }
    
    @GetMapping("/admin/delete-customer")
    public String deleteCustomer(HttpServletRequest request) throws IOException {
        long CusID = Long.parseLong(request.getParameter("CusID"));
        String username = customerService.getUsernameById(CusID);
        cloudinary.uploader().destroy(String.valueOf(CusID+"_"+ username), ObjectUtils.asMap("public_id", String.valueOf(CusID +"_"+ username)));
        customerService.deleteById(CusID);
        return "redirect:/admin/page-customer";
    }
    
    @GetMapping("/admin/add-customer")
    public String addCustomer(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        CustomerEntity customer = new CustomerEntity();
        model.addAttribute("customer", customer);
        return "ad_form_cr_customer";
    }
    
    @PostMapping("/admin/add-customer")
    public String addCustomer(@Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult br, ModelMap modelMap) {
        if (br.hasErrors()) {
            return "ad_form_cr_customer";
        } else {
            if (customerService.checkByUserName(customer.getUserName()) == 2) {
                modelMap.addAttribute("errRegister2", "UsernameExist");
            }
            if (customerService.checkEmail(customer.getEmail()) == 2) {
                modelMap.addAttribute("errRegister3", "EmailExist");
            }
            if (customerService.checkByUserName(customer.getUserName()) == 2 || customerService.checkEmail(customer.getEmail()) == 2) {
                return "ad_form_cr_customer";
            } else {
                customerService.save(customer);
                return "redirect:/admin/page-customer";
            }
        }
    }
    
    @GetMapping("/admin/edit-customer")
    public String editCustomer(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        long CusID = Long.parseLong(request.getParameter("idCus"));
        CustomerEntity customer = customerService.findById(CusID);
        model.addAttribute("customer", customer);
        return "ad_form_ed_customer";
    }
    
    @PostMapping("/admin/edit-customer")
    public String editCustomer(@Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult br, ModelMap modelMap) {
        if (br.hasErrors()) {
            return "ad_form_ed_customer";
        }
        customerService.save(customer);
        return "redirect:/admin/page-customer";
        
    }
}
