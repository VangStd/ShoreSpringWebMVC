/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.WhisListEntity;
import com.java.repository.WhisListRepository;
import com.java.service.WhisListService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class WhisListServiceimpl implements WhisListService {

    @Autowired
    private WhisListRepository whisListRepository;

    @Override
    public List<WhisListEntity> findByCusID(long l) {
        return whisListRepository.findByCusID(l);
    }

    @Override
    public void save(WhisListEntity whisListEntity) {
        if (whisListRepository.getCountByProidAndCusid(whisListEntity.getProduct().getProID(), whisListEntity.getCustomer().getCusID()) > 0) {
            whisListRepository.deleteByProIDandCusID(whisListEntity.getProduct().getProID(), whisListEntity.getCustomer().getCusID());
        } else {
            whisListRepository.save(whisListEntity);
        }
    }

}
