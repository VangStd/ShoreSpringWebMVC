/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.models.Login;
import com.java.service.LoginService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/form-login")
    public String callForm(Model model, HttpServletRequest request) {
        Login login = new Login();
        model.addAttribute("login", login);
        //remember
        String userCookie = "";
        String passCookie = "";
        Cookie cookie[] = request.getCookies();
        for (Cookie elem : cookie) {
            if (elem.getName().equals("userCookie")) {
                userCookie = elem.getValue();
            }
            if (elem.getName().equals("passCookie")) {
                passCookie = elem.getValue();
            }
        }
        model.addAttribute("userCookie", userCookie);
        model.addAttribute("passCookie", passCookie);

        return "singin";
    }

    @PostMapping("/submit-form")
    public String submitForm(@ModelAttribute("login") Login login, HttpServletRequest request, HttpServletResponse response) {
        if (loginService.loginWebsite(login) == 1) {
            HttpSession adminSession = request.getSession();
            adminSession.setAttribute("adminSession", login.getUserName());
            return "redirect:/admin/home-admin";
        }
        if (loginService.loginWebsite(login) == 2) {
            //cookie
            Cookie userCoolie = new Cookie("userCookie", login.getUserName());
            Cookie passCoolie = new Cookie("passCookie", login.getPassWord());
            if (login.isRemember()) {
                userCoolie.setMaxAge(60 * 60 * 24);
                passCoolie.setMaxAge(60 * 60 * 24);
                response.addCookie(userCoolie);
                response.addCookie(passCoolie);

            } else {
                userCoolie.setMaxAge(0);
                passCoolie.setMaxAge(0);
                response.addCookie(userCoolie);
                response.addCookie(passCoolie);
            }
            //session
            HttpSession userSession = request.getSession();
            userSession.setAttribute("userSession", login.getUserName());
            return "redirect:/home";
        }
        if (loginService.loginWebsite(login) == 3) {
            request.setAttribute("errLogin1", "Incorrect UserName And PassWord");
            return "singin";
        }
        return "singin";
    }

    @GetMapping("/logout-user")
    public String logoutWeb(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/form-login";
    }

}
