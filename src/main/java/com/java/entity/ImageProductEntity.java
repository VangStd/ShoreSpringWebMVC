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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "ImageProduct")
@Data
public class ImageProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    //private long ProID;
    private String Image1;

    private String Image2;

    private String Image3;

    private String Image4;

    private String Image5;

    //non field in db
    @Transient
    MultipartFile FileUpload2;
    
    @Transient
    MultipartFile FileUpload3;
    
    @Transient
    MultipartFile FileUpload4;
    
    @Transient
    MultipartFile FileUpload5;

    @OneToOne
    @JoinColumn(name = "ProID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductEntity products;
}
