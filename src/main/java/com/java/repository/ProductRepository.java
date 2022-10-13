/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.ProductEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "select pr.ProID,pr.ProductName,pr.SupplierID,pr.CategorieID,pr.UnitPrice,pr.UnitInStock,pr.UnitInOrder,pr.Image,pr.Status,pr.StatusSale from Product pr where pr.ProductName like ?1", nativeQuery = true)
    List<ProductEntity> findByLikeProductname(String productname);

    @Query(value = "select pr.ProID,pr.ProductName,pr.SupplierID,pr.CategorieID,pr.UnitPrice,pr.UnitInStock,pr.UnitInOrder,pr.Image,pr.Status,pr.StatusSale from Product pr where pr.StatusSale = 0 ", nativeQuery = true)
    List<ProductEntity> findAllByStatusSaleEqual0();

    @Query(value = "{CALL PaginationProduct(?1,?2)}", nativeQuery = true)
    List<ProductEntity> getAllProductByPag(int start, int end);

    @Query(value = "select  pr.ProID,pr.ProductName,pr.SupplierID,pr.CategorieID,pr.UnitPrice,pr.UnitInStock,pr.UnitInOrder,pr.Image,pr.Status,pr.StatusSale from Product pr where pr.UnitInStock <= 3", nativeQuery = true)
    List<ProductEntity> getProductByQuantity();

    @Transactional
    @Modifying
    @Query(value = "update Product set StatusSale = 0 where ProID = ?1", nativeQuery = true)
    void updateStatusSaleById(long ProID);

    @Transactional
    @Modifying
    @Query(value = "update Product set StatusSale = 1 where ProID = ?1", nativeQuery = true)
    void updateStatusSaleById1(long ProID);

    @Query(value = "select pr.ProductName from Product pr where pr.ProductName = ?1", nativeQuery = true)
    String findByProductName(String ProductName);

    @Query(value = "select count(ProID) from Product where StatusSale = 0", nativeQuery = true)
    int getCountProduct();

    @Transactional
    @Modifying
    @Query(value = "update Product set UnitInStock -= ?1,UnitInOrder +=?2 where ProID =?3", nativeQuery = true)
    void updateQuantityByProID(int Quantity, int QuantityOrder, long ProID);

}
