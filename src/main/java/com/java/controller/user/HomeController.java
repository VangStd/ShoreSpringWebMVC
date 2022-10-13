/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.controller.user;

import com.java.entity.CategorieEntity;
import com.java.entity.OrderDetailEntity;
import com.java.entity.ProductEntity;
import com.java.entity.SaleOffEntity;
import com.java.entity.ShopCartEntity;
import com.java.entity.WhisListEntity;
import com.java.service.CategorieService;
import com.java.service.CustomerService;
import com.java.service.OrderDetailService;
import com.java.service.ProductService;
import com.java.service.SaleOffService;
import com.java.service.ShopCartService;
import com.java.service.ViewWebsiteService;
import com.java.service.WhisListService;
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
public class HomeController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleOffService saleOffService;

    @Autowired
    private ShopCartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private WhisListService whisListService;

    @Autowired
    private ViewWebsiteService viewWebsiteService;

    @GetMapping(value = {"/home", "/"})
    public String homeUser(HttpServletRequest request, Model model) {
        int countCart = 0;
        if (request.getSession().getAttribute("userSession") != null) {
            String userName = (String) request.getSession().getAttribute("userSession");
            long CusID = customerService.getIdByUserName(userName);
            countCart = cartService.getCountByCusID(CusID);
            String urlAvatar = customerService.getAvatarByUserName(userName);
            model.addAttribute("avatar", urlAvatar);
        }
        model.addAttribute("countCart", countCart);
        saleOffService.updateStatusByEnddate();
        viewWebsiteService.updateQuantity();
        //product month
        List<OrderDetailEntity> listProductMonth = orderDetailService.getTop3ProductMonth("%9%");
        model.addAttribute("listTopPro", listProductMonth);
        //top product on order
        List<OrderDetailEntity> listTopProduct = orderDetailService.getTopProductOnOrder();
        model.addAttribute("listTopOnOd", listTopProduct);
        return "index";
    }

    @GetMapping("/about")
    public String pageAbout() {
        return "about";
    }

    @GetMapping("/shop")
    public String pageShop(Model model, HttpServletRequest request) {
        int pageIndex = 1;
        int countProduct = productService.getCountProduct();
        int countPag;
        if (countProduct % 2 != 0) {
            countPag = (int) Math.round(countProduct / 6 + 0.5);
        } else {
            countPag = (int) Math.round(countProduct / 6);
        }
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        if (request.getServletContext().getAttribute("listSearch") != null) {
            model.addAttribute("listProS", request.getServletContext().getAttribute("listSearch"));
            request.getServletContext().removeAttribute("listSearch");
        }
        if (request.getSession().getAttribute("userSession") != null) {
            String UserName = (String) request.getSession().getAttribute("userSession");
            long CusID = customerService.getIdByUserName(UserName);
            List<WhisListEntity> listLove = whisListService.findByCusID(CusID);
            model.addAttribute("listLovePro", listLove);
        }
        List<CategorieEntity> listCate = categorieService.findAll();
        List<ProductEntity> listPro = productService.getAllProductByPag(pageIndex, 6);
        List<SaleOffEntity> listSale = saleOffService.findAllByStatusSaleEqual1();
        model.addAttribute("listCate", listCate);
        model.addAttribute("listPro", listPro);
        model.addAttribute("listSale", listSale);
        model.addAttribute("count", countPag);
        return "shop";
    }

    @GetMapping("/shop-cart")
    public String pageShopCart(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("userSession") == null) {
            return "redirect:/form-login";
        }
        String UserName = (String) request.getSession().getAttribute("userSession");
        long CusID = customerService.getIdByUserName(UserName);
        List<ShopCartEntity> cartEntitys = cartService.findAllByStatus(CusID);

        model.addAttribute("cart", cartEntitys);
        return "shop_cart";
    }

    @GetMapping("/contact")
    public String pageContact() {
        return "contact";
    }
}
