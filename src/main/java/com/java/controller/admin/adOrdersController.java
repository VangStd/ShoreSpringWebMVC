/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.OrderDetailEntity;
import com.java.service.OrderDetailService;
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
public class adOrdersController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/admin/user-order")
    public String viewOrder(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        List<OrderDetailEntity> listOrders = orderDetailService.findAll();
        model.addAttribute("listOdd", listOrders);
        return "ad_order";
    }

    @GetMapping("/admin/delete-order")
    public String deleteOrder(HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-loginsadsass";
        }
        long orderId = Long.parseLong(request.getParameter("OrderID"));
        orderDetailService.deleteByOrderId(orderId);
        return "redirect:/admin/user-order";
    }
}
