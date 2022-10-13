/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.models.Login;
import com.java.repository.AdminRepository;
import com.java.repository.CustomerRepository;
import com.java.service.LoginService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public int loginWebsite(Login login) {

        boolean validPassAdmin = false;
        boolean validPassCustomer = false;
        Login lg = login;
        String passAdmin = adminRepository.getPassByUserName(login.getUserName());
        if (passAdmin != null) {
            validPassAdmin = BCrypt.checkpw(login.getPassWord(), passAdmin);
        }
        if (validPassAdmin) {
            //login admin success
            return 1;
        } else {
            String passCustomer = customerRepository.getPassByUserName(login.getUserName());
            if (passCustomer != null) {
                validPassCustomer = BCrypt.checkpw(login.getPassWord(), passCustomer);
            }
            if (validPassCustomer) {
                //login customer success
                return 2;
            } else {
                //login admin and customer fail
                return 3;
            }
        }
    }

}
