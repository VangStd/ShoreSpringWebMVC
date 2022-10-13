/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.service.impl;

import com.java.entity.CustomerEntity;
import com.java.repository.AdminRepository;
import com.java.repository.CustomerRepository;
import com.java.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public CustomerEntity findById(long CusID) {
        return customerRepository.findById(CusID).get();
    }

    @Override
    public int getCountCustomer() {
        return customerRepository.getCountCustomer();
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(CustomerEntity customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(long CusID) {
        customerRepository.deleteById(CusID);
    }

    @Override
    public int checkEmail(String Email) {
        String customerEmail = customerRepository.getEmailByEmail(Email);
        if (adminRepository.getCountByEmail(Email) > 0) {
            return 2;
        }
        return customerEmail != null ? 2 : 1;
    }

    @Override
    public long getIdByUserName(String UserName) {
        return customerRepository.getIdByUserName(UserName);
    }

    @Override
    public String getUsernameById(long l) {
        return customerRepository.getUsernameById(l);
    }

    @Override
    public int getCountByCodeForgot(String string) {
        return customerRepository.getCountByCodeForgot(string);
    }

    @Override
    public String getAvatarByUserName(String string) {
        return customerRepository.getAvatarByUserName(string);
    }

    @Override
    public List<CustomerEntity> getTopNewCustomer() {
        return customerRepository.getTopNewCustomer();
    }

    @Override
    public void updatePasswordById(CustomerEntity ce) {
        customerRepository.updatePasswordById(ce.getPassWord(), ce.getCusID());
    }

    @Override
    public int checkByUserName(String Username) {
        String userName = customerRepository.getUserNameByUserName(Username);
        return userName != null ? 2 : 1;
    }

    @Override
    public void updateCodeByEmail(String string, String string1) {
        customerRepository.updateCodeByEmail(string, string1);
    }

    @Override
    public void updatePasswordForgot(String string, String string1) {
        customerRepository.updatePasswordForgot(string, string1);
    }

}
