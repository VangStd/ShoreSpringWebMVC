/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.java.entity.ImageProductEntity;
import com.java.entity.ProductEntity;
import com.java.service.ImgProductService;
import com.java.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
@Controller
public class adImageController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImgProductService imgProductService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/admin/page-productimg")
    public String Index(Model model) {
        List<ImageProductEntity> list = imgProductService.findAll();
        model.addAttribute("listImg", list);
        return "ad_productimg";
    }

    @GetMapping("/admin/edit-imgproduct")
    public String Edit(Model model, HttpServletRequest request) {
        long ProID = Long.parseLong(request.getParameter("idPro"));
        ImageProductEntity imageProductEntity = imgProductService.findByProId(ProID);
        model.addAttribute("ProID", imageProductEntity.getProducts().getProID());
        model.addAttribute("product", imageProductEntity);
        return "ad_form_ed_productimg";
    }

    @PostMapping("/admin/edit-imgproduct")
    public String Edit(@ModelAttribute("product") ImageProductEntity entity, HttpServletRequest request) throws IOException {
        //
        long ProID = Long.parseLong(request.getParameter("ProID"));
        ProductEntity productEntity = productService.findById(ProID);
        entity.setProducts(productEntity);
        //
        int n = 0;
        String ImageID = String.valueOf(entity.getProducts().getProID());
        MultipartFile[] files = {entity.getFileUpload2(), entity.getFileUpload3(), entity.getFileUpload4(), entity.getFileUpload5()};
        String[] arrImage = {entity.getImage2(), entity.getImage3(), entity.getImage4(), entity.getImage5()};
        String[] arrUrl = new String[files.length];

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                cloudinary.uploader().destroy(n + ImageID, ObjectUtils.asMap("public_id", n + ImageID));
                Map img = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", n + ImageID));
                arrUrl[n] = (String) img.get("secure_url");
            } else {
                arrUrl[n] = arrImage[n];
            }
            n++;
        }
        entity.setImage2(arrUrl[0]);
        entity.setImage3(arrUrl[1]);
        entity.setImage4(arrUrl[2]);
        entity.setImage5(arrUrl[3]);
        imgProductService.save(entity);
        return "redirect:/admin/page-productimg";
    }


}
