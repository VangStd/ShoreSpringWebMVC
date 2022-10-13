/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.ProductEntity;
import com.java.repository.ProductRepository;
import com.java.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity findById(long ProID) {
        return productRepository.findById(ProID).get();
    }

    @Override
    public List<ProductEntity> findByLikeProductname(String string) {
        return productRepository.findByLikeProductname(string);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findAllByStatusSaleEqual0() {
        return productRepository.findAllByStatusSaleEqual0();
    }

    @Override
    public List<ProductEntity> getAllProductByPag(int start, int end) {
        return productRepository.getAllProductByPag(start, end);
    }

    @Override
    public List<ProductEntity> getProductByQuantity() {
        return productRepository.getProductByQuantity();
    }

    @Override
    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public void updateStatusSaleById(long l) {
        productRepository.updateStatusSaleById(l);
    }

    @Override
    public void updateStatusSaleById1(long l) {
        productRepository.updateStatusSaleById1(l);
    }

    @Override
    public void deleteById(long ProID) {
        productRepository.deleteById(ProID);
    }

    @Override
    public int checkProductName(String ProName) {
        String entity = productRepository.findByProductName(ProName);
        if (entity != null) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public int getCountProduct() {
        return productRepository.getCountProduct();
    }

}
