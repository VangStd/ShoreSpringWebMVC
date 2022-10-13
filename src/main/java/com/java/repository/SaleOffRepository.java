/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.repository;

import com.java.entity.SaleOffEntity;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kyqua
 */
public interface SaleOffRepository extends JpaRepository<SaleOffEntity, Long> {

    @Query(value = "select sl.ID,sl.Percents,sl.BeginDate,sl.EndDate,sl.Status,pr.ProID,pr.ProductName,pr.SupplierID,pr.CategorieID,pr.UnitPrice,pr.UnitInStock,pr.UnitInOrder,pr.Image,pr.Status,pr.StatusSale from SaleOff sl inner join Product pr on sl.ProID = pr.ProID where pr.StatusSale=1 and sl.Status='Active'", nativeQuery = true)
    List<SaleOffEntity> findAllByStatusSaleEqual1();

    @Query(value = "select sl.* from SaleOff sl where ProID =?1 and sl.Status = 'Active'", nativeQuery = true)
    SaleOffEntity findByProID(long ProID);

    @Query(value = "select sl.* from SaleOff sl where sl.EndDate <=?1 and sl.Status = 'Active'", nativeQuery = true)
    List<SaleOffEntity> findAllByEndDate(Date endDate);

    @Query(value = "select EndDate from SaleOff where EndDate <=?1", nativeQuery = true)
    List<Date> getEndDateByEndDate(Date date);

    @Transactional
    @Modifying
    @Query(value = "delete from SaleOff where EndDate ?1", nativeQuery = true)
    void deleteByEndDate(Date date);

    @Transactional
    @Modifying
    @Query(value = "update SaleOff set Status = 'Deactive' where ID = ?1", nativeQuery = true)
    void updateStatusById(long id);

    @Transactional
    @Modifying
    @Query(value = "update SaleOff set Status = 'Deactive' where EndDate between ?1 and ?2 ", nativeQuery = true)
    void updateStatusByEnddate(Date today, Date endate);
}
