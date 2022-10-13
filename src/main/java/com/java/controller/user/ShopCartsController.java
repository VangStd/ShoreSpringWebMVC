/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.entity.CustomerEntity;
import com.java.entity.ProductEntity;
import com.java.entity.ShopCartEntity;
import com.java.service.CustomerService;
import com.java.service.ProductService;
import com.java.service.ShopCartService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class ShopCartsController {

    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @GetMapping("/add-shopcart")
    public String addShopcart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        } else {
            long ProID = Long.parseLong(request.getParameter("ProID"));
            String UserName = (String) request.getSession().getAttribute("userSession");
            long CusID = customerService.getIdByUserName(UserName);

            CustomerEntity customerEntity = customerService.findById(CusID);
            ProductEntity productEntity = productService.findById(ProID);
            LocalDate date = LocalDate.now();

            Date dateNow = java.sql.Date.valueOf(date);
            ShopCartEntity entity = new ShopCartEntity();
            entity.setProductss(productEntity);
            entity.setCustomers(customerEntity);
            entity.setDates(dateNow);
            entity.setStatus("Active");
            entity.setQuantity(1);

            shopCartService.save(entity);
            return "redirect:/shop";
        }
    }

    @GetMapping("/update-shopcart")
    public String updateQuantityShopCart(HttpServletRequest request) {
        String UserName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(UserName);
        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
        long ProID = Long.parseLong(request.getParameter("ProductID"));
        shopCartService.updateQuantityByAjax(Quantity, ProID, CusID);
        return "redirect:/shop-cart";
    }

    @GetMapping("/delete-shopcart")
    public String deleteStatusShopcart(HttpServletRequest request) {
        //delete by id
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        }
        long cartId = Long.parseLong(request.getParameter("Id"));
        shopCartService.updateStatusById(cartId);
        return "redirect:/shop-cart";
    }

    @GetMapping("/delete-all-shopcart")
    public String deleteAllShopCart(HttpServletRequest request) {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        }
        String UserName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(UserName);
        shopCartService.updateStatusByCusid(CusID);
        return "redirect:/shop-cart";
    }
}
