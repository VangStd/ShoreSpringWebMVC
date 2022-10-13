/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.service;

import com.java.entity.WhisListEntity;
import java.util.List;

/**
 *
 * @author kyqua
 */
public interface WhisListService {

    List<WhisListEntity> findByCusID(long CusID);
    
    void save(WhisListEntity whisListEntity);
}
