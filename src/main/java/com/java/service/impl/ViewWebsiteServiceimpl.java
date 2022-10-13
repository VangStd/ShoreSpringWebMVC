/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.repository.ViewWebsiteRepository;
import com.java.service.ViewWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class ViewWebsiteServiceimpl implements ViewWebsiteService {

    @Autowired
    private ViewWebsiteRepository websiteRepository;

    @Override
    public int getQuantityViewWebsite() {
        return websiteRepository.getQuantityViewWebsite();
    }

    @Override
    public void updateQuantity() {
        websiteRepository.updateQuantity();
    }

}
