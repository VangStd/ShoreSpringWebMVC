/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.CustomerEntity;
import com.java.entity.ProductEntity;
import com.java.service.AdminService;
import com.java.service.CustomerService;
import com.java.service.OrderDetailService;
import com.java.service.ProductService;
import com.java.service.ViewWebsiteService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author kyqua
 */
@Controller
public class AdminHomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ViewWebsiteService viewWebsiteService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin/home-admin")
    public String homeAdmin(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("adminSession") != null) {
            HttpSession hs = request.getSession();
            List<CustomerEntity> listTopNewCustomer = customerService.getTopNewCustomer();
            List<ProductEntity> listProQuantityLess3 = productService.getProductByQuantity();
            int[] arrMonth = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            double sale = orderDetailService.getSaleOfMonth("%-10-%");
            int totalOrder = orderDetailService.getCountTotalOrder();
            int totalViewPage = viewWebsiteService.getQuantityViewWebsite();
            double totalPriceOnInvoice = orderDetailService.getSumTotalPrice();
            int memberOfWebsite = customerService.getCountCustomer();
            String username = (String) request.getSession().getAttribute("adminSession");
            String urlImg = adminService.getAvatarByUsername(username);
            LocalDate localDate = LocalDate.now();
            model.addAttribute("list", listProQuantityLess3);
            hs.setAttribute("list", listProQuantityLess3);
            model.addAttribute("listTopNewCus", listTopNewCustomer);
            model.addAttribute("sales", sale);
            model.addAttribute("month", localDate.getMonthValue());
            model.addAttribute("listMonth", arrMonth);
            model.addAttribute("totalOrder", totalOrder);
            model.addAttribute("totalViewpage", totalViewPage);
            model.addAttribute("totalPriceOnInvoice", totalPriceOnInvoice);
            model.addAttribute("totalCustomer", memberOfWebsite);
            model.addAttribute("urlImg", urlImg);
        }
        return "ad_index";
    }

    @PostMapping("/admin/chose-month")
    public @ResponseBody
    String showSalesOfMonth(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login-err-ajax";
        }
        String month = request.getParameter("month");
        model.addAttribute("month", month);
        if (month.length() == 1) {
            month = "0" + month;
        }
        String sale = String.valueOf(orderDetailService.getSaleOfMonth("%-" + month + "-%"));
        model.addAttribute("sales", sale);
        return sale;
    }

    @GetMapping(value = "/admin/data-chart", produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    List<Double> showDataChart(HttpServletResponse response) {
        List<Double> listMoney = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            if (i <= 9) {
                String month = "0" + String.valueOf(i);
                double money = orderDetailService.getSaleOfMonth("%-" + month + "-%");
                listMoney.add(money);
            } else {
                String month = String.valueOf(i);
                double money = orderDetailService.getSaleOfMonth("%-" + month + "-%");
                listMoney.add(money);
            }
        }
        return listMoney;
    }

}
