/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

/**
 *
 * @author kyqua
 */
import com.java.repository.OrderDetailRepository;
import com.java.service.CustomerService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    private CustomerService customerService;

    public static void main(String args[]) throws AddressException, MessagingException {
        LocalDate localDate = LocalDate.now();
        LocalDate date = LocalDate.of(2002, 3, 29);
        System.out.println(localDate.getMonthValue());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(date.format(formatter));
        System.out.println(localDate.format(formatter));
        System.out.println(date.getMonthValue());
        String str = "2022-09-07";
    }

}
