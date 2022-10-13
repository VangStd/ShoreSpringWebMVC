/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.SupplierEntity;
import com.java.service.SupplierService;
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
public class adSuppliersController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/admin/page-supplier")
    public String homeSupplier(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        } else {
            List<SupplierEntity> list = supplierService.findAll();
            model.addAttribute("listSup", list);
            return "ad_supplier";
        }
    }

    @GetMapping("/admin/add-supplier")
    public String addSupplier(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        SupplierEntity supplier = new SupplierEntity();
        model.addAttribute("supplier", supplier);
        return "ad_form_cr_supplier";
    }

    @PostMapping("/admin/add-supplier")
    public String addSupplier( @ModelAttribute("supplier")@Valid SupplierEntity supplier, BindingResult br, HttpServletRequest request) {
        if (br.hasErrors()) {
            return "ad_form_cr_supplier";
        }
        if (supplierService.checkName(supplier.getCompanyName()) == 2) {
            request.setAttribute("errSup1", "NameExist");
            return "ad_form_cr_supplier";
        }

        supplierService.save(supplier);
        return "redirect:/admin/page-supplier";
    }

    @GetMapping("/admin/edit-supplier")
    public String editSupplier(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        }
        long ID = Long.parseLong(request.getParameter("idSup"));
        SupplierEntity supplier = supplierService.findById(ID);
        model.addAttribute("supplier", supplier);
        return "ad_form_ed_supplier";
    }

    @PostMapping("/admin/edit-supplier")
    public String editSupplier( @ModelAttribute("supplier") @Valid SupplierEntity supplier, BindingResult br, HttpServletRequest request, Model model) {
        if (br.hasErrors()) {

            return "ad_form_ed_supplier";
        } else {
            String CompanyName = request.getParameter("CompanyName");
            supplierService.save(supplier);
            return "redirect:/admin/page-supplier";
        }

    }

    @GetMapping("/admin/delete-supplier")
    public String deleteSupplier(HttpServletRequest request) {
        long SupID = Long.parseLong(request.getParameter("SupID"));
        supplierService.Delete(SupID);
        return "redirect:/admin/page-supplier";
    }
}
