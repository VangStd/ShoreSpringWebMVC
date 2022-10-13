/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.SupplierEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface SupplierService {

    List<SupplierEntity> findAll();

    SupplierEntity findById(long ID);

    void save(SupplierEntity supplier);

    void Delete(long ID);

    int checkName(String CompanyName);
}
