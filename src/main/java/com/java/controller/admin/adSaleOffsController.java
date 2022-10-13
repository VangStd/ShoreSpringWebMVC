 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.ProductEntity;
import com.java.entity.SaleOffEntity;
import com.java.service.ProductService;
import com.java.service.SaleOffService;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
public class adSaleOffsController {
    
    @Autowired
    private SaleOffService saleOffService;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/admin/page-saleoff")
    public String Index(Model model) {
        List<SaleOffEntity> list = saleOffService.findAll();
        model.addAttribute("listSale", list);
        return "ad_saleoff";
    }
    
    @GetMapping("/admin/add-saleoffs")
    public String Create(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        SaleOffEntity saleOffEntity = new SaleOffEntity();
        List<ProductEntity> listPro = productService.findAllByStatusSaleEqual0();
        model.addAttribute("saleoff", saleOffEntity);
        model.addAttribute("listPro", listPro);
        return "ad_form_cr_saleoff";
    }
    
    @PostMapping("/admin/save-add-saleoffs")
    public String Create(@Valid @ModelAttribute("saleoff") SaleOffEntity entity, BindingResult br, HttpServletRequest request, Model model) throws ParseException, ParseException {
        if (br.hasErrors()) {
            List<ProductEntity> listPro = productService.findAllByStatusSaleEqual0();
            model.addAttribute("listPro", listPro);
            return "ad_form_cr_saleoff";
        } else {
            long ProID = Long.parseLong(request.getParameter("ProID"));
            String beginDate = request.getParameter("start");
            String endDate = request.getParameter("end");
            LocalDate date1 = LocalDate.parse(beginDate);
            LocalDate date2 = LocalDate.parse(endDate);
            Date stDate = java.sql.Date.valueOf(date1);
            Date edDate = java.sql.Date.valueOf(date2);
            
            LocalDate localDate = LocalDate.now();
            Date dateNow = java.sql.Date.valueOf(localDate);
            //begindate must greater date now
            if (stDate.compareTo(dateNow) < 0) {
                List<ProductEntity> listPro = productService.findAllByStatusSaleEqual0();
                model.addAttribute("listPro", listPro);
                request.setAttribute("errDatebegin1", "Err");
            }
            if (edDate.compareTo(dateNow) <= 0) {
                List<ProductEntity> listPro = productService.findAllByStatusSaleEqual0();
                model.addAttribute("listPro", listPro);
                request.setAttribute("errDatebegin2", "Err");
            }
            if (stDate.compareTo(dateNow) < 0 || edDate.compareTo(dateNow) < 0) {
                return "ad_form_cr_saleoff";
            }
            // List<SaleOffEntity> list = saleOffService.findAllByEndDate(dada);
            entity.setStatus("Active");
            entity.setBeginDate(stDate);
            entity.setEndDate(edDate);
            ProductEntity productEntity = productService.findById(ProID);
            entity.setProducts(productEntity);
            saleOffService.save(entity);
            productService.updateStatusSaleById1(entity.getProducts().getProID());
            return "redirect:/admin/page-saleoff";
        }
    }
    
    @GetMapping("/admin/edit-saleoff")
    public String Edit(Model model, HttpServletRequest request) {
        long ID = Long.parseLong(request.getParameter("Id"));
        SaleOffEntity entity = saleOffService.findById(ID);
        model.addAttribute("sale", entity);
        return "ad_form_ed_saleoff";
    }
    
    @PostMapping("/admin/edit-saleoff")
    public String Edit(@Valid @ModelAttribute("sale") SaleOffEntity entity, BindingResult br, Model model, HttpServletRequest request) {
        SaleOffEntity saleOff = saleOffService.findById(entity.getID());
        entity.setBeginDate(saleOff.getBeginDate());
        entity.setEndDate(saleOff.getEndDate());
        entity.setProducts(saleOff.getProducts());
        if (br.hasErrors()) {
            SaleOffEntity sale = saleOffService.findById(entity.getID());
            entity.setProducts(sale.getProducts());
            model.addAttribute("sale", entity);
            return "ad_form_ed_saleoff";
        } else {
            String endDate = request.getParameter("end");
            LocalDate date2 = LocalDate.parse(endDate);
            Date edDate = java.sql.Date.valueOf(date2);
            LocalDate localDate = LocalDate.now();
            Date dateNow = java.sql.Date.valueOf(localDate);
            if (edDate.compareTo(dateNow) <= 0) {
                request.setAttribute("errDatebegin2", "Err");
                return "ad_form_ed_saleoff";
            }
            entity.setEndDate(edDate);
            saleOffService.save(entity);
            return "redirect:/admin/page-saleoff";
        }
    }
    
    @GetMapping("/admin/delete-saleoff")
    public String Delete(HttpServletRequest request) {
        long Id = Long.parseLong(request.getParameter("SaleID"));
        SaleOffEntity entity = saleOffService.findById(Id);
        productService.updateStatusSaleById(entity.getProducts().getProID());
        if (entity.getStatus().equalsIgnoreCase("active")) {
            saleOffService.updateStatusById(Id);
        } else {
            saleOffService.deleteByID(Id);
        }
        return "redirect:/admin/page-saleoff";
    }
}
