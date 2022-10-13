/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Admin")
@Data
public class AdminEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String FullName;

    private String Address;

    private String Phone;

    private String Email;

    private String UserName;

    private String PassWord;

    private String Avatar;

    @Transient
    private MultipartFile urlAvatar;

    @Transient
    @Length(min = 7, max = 20, message = "Password must greater 7 character ")
    private String NewPassword;

    @Transient
    private String confirmNewPassword;
}
