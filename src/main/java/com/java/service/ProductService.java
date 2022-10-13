/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.ProductEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface ProductService {

    ProductEntity findById(long ProID);

    List<ProductEntity> findByLikeProductname(String productname);
    
    List<ProductEntity> getAllProductByPag(int start, int end);

    List<ProductEntity> findAll();

    List<ProductEntity> findAllByStatusSaleEqual0();
    
    List<ProductEntity> getProductByQuantity();

    void save(ProductEntity product);

    void deleteById(long ProID);

    int checkProductName(String ProName);

    void updateStatusSaleById(long ProID);

    void updateStatusSaleById1(long ProID);
    
    int getCountProduct();
}
