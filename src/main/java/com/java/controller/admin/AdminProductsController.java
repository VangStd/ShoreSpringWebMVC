/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entity.CategorieEntity;
import com.java.entity.ImageProductEntity;
import com.java.entity.ProductEntity;
import com.java.entity.SupplierEntity;
import com.java.service.CategorieService;
import com.java.service.ImgProductService;
import com.java.service.ProductService;
import com.java.service.SupplierService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
public class AdminProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ImgProductService imgProductService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/admin/page-product")
    public String homeProduct(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {
            List<ProductEntity> list = productService.findAll();
            model.addAttribute("listPro", list);

        }
        return "ad_product";
    }

    @GetMapping("/admin/add-product")
    public String addProduct(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") != null) {

            ProductEntity product = new ProductEntity();
            List<CategorieEntity> listCate = categorieService.findAll();
            List<SupplierEntity> listSup = supplierService.findAll();

            model.addAttribute("listCate", listCate);
            model.addAttribute("listSup", listSup);
            model.addAttribute("product", product);
        }
        return "ad_form_cr_product";
    }

    @PostMapping("/admin/add-product")
    public String addProduct(@Valid @ModelAttribute("product") ProductEntity product, BindingResult br, Model model, HttpServletRequest request) throws IOException {
        return nonCreate(product, br, model, request);
    }

    @GetMapping("/admin/edit-product")
    public String editProduct(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("adminSession") == null) {
            return "redirect:/form-login";
        } else {
            long ProID = Long.parseLong(request.getParameter("idPro"));
            ProductEntity product = productService.findById(ProID);
            List<CategorieEntity> listCate = categorieService.findAll();
            List<SupplierEntity> listSup = supplierService.findAll();
            model.addAttribute("listCate", listCate);
            model.addAttribute("listSup", listSup);
            model.addAttribute("product", product);
            return "ad_form_ed_product";
        }
    }

    @PostMapping("/admin/edit-product")
    public String editProduct(@Valid @ModelAttribute("product") ProductEntity product, BindingResult br, Model model, HttpServletRequest request) throws IOException {
        return nonEdit(product, br, model, request);
    }

    @GetMapping("/admin/delete-product")
    public String deleteProduct(HttpServletRequest request) throws IOException {
        long ProID = Long.parseLong(request.getParameter("ProID"));
        String Id = request.getParameter("ProID");
        cloudinary.uploader().destroy(Id, ObjectUtils.asMap("public_id", Id));
        cloudinary.uploader().destroy(String.valueOf(ProID), ObjectUtils.asMap("public_id", String.valueOf(ProID)));
        imgProductService.deleteByProId(ProID);
        productService.deleteById(ProID);
        return "redirect:/admin/page-product";
    }

    public String nonCreate(@Valid @ModelAttribute("product") ProductEntity product, BindingResult br, Model model, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("adminSession") == null) {
            long idSup = Long.parseLong(request.getParameter("SupID"));
            long idCate = Long.parseLong(request.getParameter("CateID"));

            if (br.hasErrors()) {
                setModel(model);
                return "ad_form_cr_product";
            } else {
                if (productService.checkProductName(product.getProductName()) == 2) {
                    setModel(model);
                    model.addAttribute("errAddPro1", "ProductNameExist");
                    return "ad_form_cr_product";
                }
                //upload anh

                // product.setImage(urlImg);
                //end upload
                CategorieEntity categorieEntity = categorieService.findByID(idCate);
                SupplierEntity supplierEntity = supplierService.findById(idSup);
                product.setCategorie(categorieEntity);
                product.setSupplier(supplierEntity);
                productService.save(product);
                ProductEntity pr = product;
                String ImageID = String.valueOf(pr.getProID());
                cloudinary.uploader().destroy(ImageID, ObjectUtils.asMap("public_id", ImageID));
                Map mapImg = cloudinary.uploader().upload(product.getFileUpload().getBytes(), ObjectUtils.asMap("public_id", ImageID));
                String urlImg = (String) mapImg.get("secure_url");
                pr.setImage(urlImg);
                productService.save(product);
                //upload table img product
                ImageProductEntity imageProductEntity = new ImageProductEntity();
                imageProductEntity.setImage1(product.getImage());
                imageProductEntity.setImage2(product.getImage());
                imageProductEntity.setImage3(product.getImage());
                imageProductEntity.setImage4(product.getImage());
                imageProductEntity.setImage5(product.getImage());
                imageProductEntity.setProducts(product);
                imgProductService.save(imageProductEntity);
            }
        }
        return "redirect:/admin/page-product";

    }

    public String nonEdit(@Valid @ModelAttribute("product") ProductEntity product, BindingResult br, Model model, HttpServletRequest request) throws IOException {
        if (request.getSession().getAttribute("adminSession") == null) {
            if (br.hasErrors()) {
                setModel(model);

                long supId = Long.parseLong(request.getParameter("SupID"));
                long cateId = Long.parseLong(request.getParameter("CateID"));
                CategorieEntity categorieEntity = categorieService.findByID(cateId);
                SupplierEntity supplierEntity = supplierService.findById(supId);
                model.addAttribute("cate", categorieEntity);
                model.addAttribute("sup", supplierEntity);
                return "ad_form_ed_product";
            } else {
                String ImageID = String.valueOf(product.getProID());
                long supId = Long.parseLong(request.getParameter("SupID"));
                long cateId = Long.parseLong(request.getParameter("CateID"));
                CategorieEntity categorieEntity = categorieService.findByID(cateId);
                SupplierEntity supplierEntity = supplierService.findById(supId);
                product.setCategorie(categorieEntity);
                product.setSupplier(supplierEntity);
                //set option view
                if (!product.getFileUpload().isEmpty()) {
                    cloudinary.uploader().destroy(ImageID, ObjectUtils.asMap("public_id", ImageID));
                    Map mapImg = cloudinary.uploader().upload(product.getFileUpload().getBytes(), ObjectUtils.asMap("resouce_type", "auto", "public_id", ImageID));
                    String urlImg = (String) mapImg.get("secure_url");
                    product.setImage(urlImg);
                } else {
                }
                productService.save(product);
            }
        }
        return "redirect:/admin/page-product";
    }

    void setModel(Model model) {
        List<CategorieEntity> listCate = categorieService.findAll();
        List<SupplierEntity> listSup = supplierService.findAll();

        model.addAttribute("listCate", listCate);
        model.addAttribute("listSup", listSup);

    }
}
