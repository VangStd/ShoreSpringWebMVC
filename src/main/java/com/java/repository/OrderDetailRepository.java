/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.OrderDetailEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

    @Query(value = "select odd.* from Orders od inner join OrderDetails odd on od.OrderID = odd.OrderID where od.CusID = ?1", nativeQuery = true)
    List<OrderDetailEntity> getAllOrderdetailsByCusID(long cusId);

    @Transactional
    @Modifying
    @Query(value = "delete from OrderDetails where OrderID = ?1", nativeQuery = true)
    void deleteByOrderId(long id);

    @Query(value = "{CALL PROC_Sales(?1)}", nativeQuery = true)
    double getSaleOfMonth(String month);

    @Query(value = "{CALL PROC_CountSaleOfMonth(?1)}", nativeQuery = true)
    int getCountSaleByMonth(String month);

    @Query(value = "select SUM(TotalPrice) from OrderDetails", nativeQuery = true)
    double getSumTotalPrice();

    @Query(value = "select COUNT(ID) from OrderDetails ", nativeQuery = true)
    int getCountTotalOrder();

    @Query(value = "{CALL PROC_ProductMonth(?1)}", nativeQuery = true)
    List<OrderDetailEntity> getTop3ProductMonth(String month);

    @Query(value = "{CALL PROC_FeaturedProduct}", nativeQuery = true)
    List<OrderDetailEntity> getTopProductOnOrder();

}
