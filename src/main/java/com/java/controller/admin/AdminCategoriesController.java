/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.java.entity.CategorieEntity;
import com.java.service.CategorieService;
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
public class AdminCategoriesController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping("/admin/page-categorie")
    public String homeCategorie(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
            List<CategorieEntity> list = categorieService.findAll();
            model.addAttribute("listCate", list);
        }
        return "ad_categorie";
    }

    @GetMapping("/admin/add-categorie")
    public String addCategorie(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
            CategorieEntity categorie = new CategorieEntity();
            model.addAttribute("categorie", categorie);
        }
        return "ad_form_cr_categorie";
    }

    @PostMapping("/admin/add-categorie")
    public String addCategorie(@Valid @ModelAttribute("categorie") CategorieEntity categorie, BindingResult br, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
            if (br.hasErrors()) {
                return "ad_form_cr_categorie";
            } else {
                if (categorieService.checkName(categorie.getCateName()) == 2) {
                    request.setAttribute("addCate1", "CategorieNameExist");
                    return "ad_form_cr_categorie";
                } else {
                    categorieService.save(categorie);
                    return "redirect:/admin/page-categorie";
                }
            }
        }
        return "form-login";
    }

    @GetMapping("/admin/edit-categorie")
    public String editCategorie(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
//            return "redirect:/form-login";
//        } else {
            long ID = Long.parseLong(request.getParameter("idCate"));
            CategorieEntity categorie = categorieService.findByID(ID);
            model.addAttribute("categorie", categorie);
        }
        return "ad_form_ed_categorie";
    }

    @PostMapping("/admin/edit-categorie")
    public String editCategorie(@Valid @ModelAttribute("categorie") CategorieEntity categorie, BindingResult br, HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("adminSession") != null) {
            if (br.hasErrors()) {
                return "ad_form_ed_categorie";
            } else {
                String cateNameNew = request.getParameter("CateName");
                if (cateNameNew.equalsIgnoreCase(categorie.getCateName())) {
                    categorieService.save(categorie);
                } else {
                    if (categorieService.checkName(cateNameNew) == 2) {
                        request.setAttribute("editCate1", "CategorieNameExist");
                        model.addAttribute("cateName", cateNameNew);
                        return "ad_form_ed_categorie";
                    } else {
                        categorie.setCateName(cateNameNew);
                        categorieService.save(categorie);
                        return "redirect:/admin/page-categorie";
                    }
                }
            }
        }
        return "redirect:/admin/page-categorie";
    }

    @GetMapping("/admin/delete-categorie")
    public String deleteCategorie(HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
            long ID = Long.parseLong(request.getParameter("CateID"));
            categorieService.deleteById(ID);
            return "redirect:/admin/page-categorie";
        } else {
            return "sdaaaaaa";
        }
    }

}
