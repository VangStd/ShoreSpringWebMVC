/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.ShopCartEntity;
import com.java.service.ShopCartService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class adShopingCartsController {

    @Autowired
    private ShopCartService cartService;

    @GetMapping("/admin/page-shopingcart")
    public String Index(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        List<ShopCartEntity> listShopCart = cartService.findAll();
        model.addAttribute("listShop", listShopCart);
        return "ad_shopingcart";
    }

    @GetMapping("/admin/delete-shopcart-by-id")
    public String DeleteByID(HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-loginsadsad";
        }
        long ID = Long.parseLong(request.getParameter("ID"));
        cartService.deleteByIdAndStatus(ID);
        return "redirect:/admin/page-shopingcart";
    }

    @GetMapping("/admin/delete-all-shopcart-by-cusid")
    public String DeleteAllByCusId(HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-loginnasdsa";
        }
        long CusID = Long.parseLong(request.getParameter("CusID"));
        cartService.deleteByCusidAndStatus(CusID);
        return "redirect:/admin/page-shopingcart";
    }

}
