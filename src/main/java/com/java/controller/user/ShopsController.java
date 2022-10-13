/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.entity.CustomerEntity;
import com.java.entity.ImageProductEntity;
import com.java.entity.ProductEntity;
import com.java.entity.SaleOffEntity;
import com.java.entity.WhisListEntity;
import com.java.service.CustomerService;
import com.java.service.ImgProductService;
import com.java.service.ProductService;
import com.java.service.SaleOffService;
import com.java.service.WhisListService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kyqua
 */
@Controller
public class ShopsController {
    
    @Autowired
    private ImgProductService imgProductService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private SaleOffService saleOffService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private WhisListService whisListService;
    
    @GetMapping("/shop-detail")
    public String shopDetail(Model model, HttpServletRequest request) {
        long ProID = Long.parseLong(request.getParameter("idPro"));
        ImageProductEntity imageProduct = imgProductService.findByProId(ProID);
        ProductEntity productEntity = productService.findById(ProID);
        if (productEntity.getStatusSale() > 0) {
            SaleOffEntity saleOf = saleOffService.findByProID(ProID);
            double priceSale = Math.ceil(productEntity.getUnitPrice() - (productEntity.getUnitPrice() * saleOf.getPercents() / 100));
            productEntity.setUnitPrice(priceSale);
        }
        model.addAttribute("product", productEntity);
        model.addAttribute("imageProduct", imageProduct);
        return "shop_detail";
    }
    
    @PostMapping("/search-product")
    public String searchProduct(HttpServletRequest request, Model model) {
        String productname = request.getParameter("nameprod");
        List<ProductEntity> listPro = productService.findByLikeProductname("%" + productname + "%");
        
        request.getServletContext().removeAttribute("listSearch");
        request.getServletContext().setAttribute("listSearch", listPro);
        return "redirect:/shop";
    }
    
    @GetMapping("/love-product")
    public String likeProduct(HttpServletRequest request) {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login-erriaas";
        }
        String userName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(userName);
        long ProID = Long.parseLong(request.getParameter("ProID"));
        CustomerEntity customerEntity = customerService.findById(CusID);
        ProductEntity productEntity = productService.findById(ProID);
        WhisListEntity whisListEntity = new WhisListEntity();
        whisListEntity.setCustomer(customerEntity);
        whisListEntity.setProduct(productEntity);
        whisListService.save(whisListEntity);
        return "redirect:/shop";
    }
    
}
