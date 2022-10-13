/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.entity.CustomerEntity;
import com.java.entity.OrderDetailEntity;
import com.java.entity.OrderEntity;
import com.java.entity.ProductEntity;
import com.java.entity.SaleOffEntity;
import com.java.entity.ShopCartEntity;
import com.java.service.CustomerService;
import com.java.service.OrderDetailService;
import com.java.service.OrderService;
import com.java.service.ProductService;
import com.java.service.SaleOffService;
import com.java.service.ShopCartService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
public class OrdersController {
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ShopCartService shopCartService;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderDetailService orderDetailService;
    
    @Autowired
    private SaleOffService saleOffService;
    
    @PostMapping("/sigle-order-product")
    public String orderProduct(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        }
        String[] listOrder = request.getParameterValues("orderPro");
        if (listOrder == null) {
            request.getServletContext().setAttribute("errCheck1", "notproductchecked");
            return "redirect:/shop-cart";
        }
        OrderEntity orderEntity = new OrderEntity();
        String UserName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(UserName);
        CustomerEntity customerEntity = customerService.findById(CusID);
        List<ShopCartEntity> listShopCart = new ArrayList<>();
        for (String id : listOrder) {
            long ProID = Long.parseLong(id);
            ShopCartEntity shopCartEntity = shopCartService.findByProIDandCusID(ProID, CusID);
            listShopCart.add(shopCartEntity);
        }
        model.addAttribute("cus", customerEntity);
        model.addAttribute("shopcart", listShopCart);
        model.addAttribute("order", orderEntity);
        return "sigle_order";
    }
    
    @PostMapping("/sigle-order-product1")
    public String orderProduct(@ModelAttribute("order") @Valid OrderEntity orderEntity, HttpServletRequest request) {
        String Id[] = request.getParameterValues("proid");
        String Qty[] = request.getParameterValues("quantity");
        int i = 0;
        for (String string : Id) {
            long ProID = Long.parseLong(string);
            long CusID = Long.parseLong(request.getParameter("cusid"));
            int Quantity = Integer.parseInt(Qty[i]);
            CustomerEntity customerEntity = customerService.findById(CusID);
            ProductEntity productEntity = productService.findById(ProID);
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date date = java.sql.Date.valueOf(localDate.format(formatter));
            orderEntity.setCutomers(customerEntity);
            orderEntity.setOrderDate(date);
            orderEntity.setStatus("Active");
            
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setProductod(productEntity);
            orderDetailEntity.setUnitPrice(productEntity.getUnitPrice());
            if (productEntity.getStatusSale() > 0) {
                SaleOffEntity saleOffEntity = saleOffService.findByProID(ProID);
                orderDetailEntity.setDiscount(Math.ceil(productEntity.getUnitPrice() * saleOffEntity.getPercents() / 100));
                orderDetailEntity.setPriceDisCount(productEntity.getUnitPrice() - Math.ceil(productEntity.getUnitPrice() * saleOffEntity.getPercents() / 100));
                orderDetailEntity.setTotalPrice(Quantity * productEntity.getUnitPrice() - Math.ceil(productEntity.getUnitPrice() * saleOffEntity.getPercents() / 100));
            } else {
                orderDetailEntity.setPriceDisCount(productEntity.getUnitPrice());
                orderDetailEntity.setTotalPrice(Quantity * productEntity.getUnitPrice());
            }
            orderDetailEntity.setQuantity(Quantity);
            orderService.save(orderEntity, orderDetailEntity);
            i++;
        }
        return "redirect:/home";
    }
    
    @GetMapping("/my-order")
    public String myOrder(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        }
        String UserName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(UserName);
        List<OrderDetailEntity> listOrders = orderDetailService.getAllOrderdetailsByCusID(CusID);
        
        model.addAttribute("listOdd", listOrders);
        return "myorder";
    }
    
}
