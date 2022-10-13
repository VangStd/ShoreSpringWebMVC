/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Customer")
@Data
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CusID;

    @NotEmpty(message = "Please Enter FullName * ")
    private String FullName;

    private String Phone;

    private String Address;

    @NotEmpty(message = "Please Enter Email * ")
    private String Email;

    private int Gender;

    @Pattern(regexp = "[a-zA-Z]{1}[a-zA-Z0-9]{5,15}", message = "Username must begin character and than 6 ")
    private String UserName;

    @Length(min = 7,message = "Password must has 7 character")
    private String PassWord;

    private String CodeForgot;

    private String Avatar;

    @Transient
    private MultipartFile avatarUrl;

    @OneToMany(mappedBy = "customers", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ShopCartEntity> shopcart;

    @OneToMany(mappedBy = "cutomers", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<OrderEntity> orders;

    @OneToMany(mappedBy = "customer")
    private List<WhisListEntity> whislist;

}
