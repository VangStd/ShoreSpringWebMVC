/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Product")
@Data
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProID")
    private long ProID;

    @NotEmpty(message = "Please Enter ProductName * ")
    @Column(name = "ProductName")
    private String ProductName;

    @Range(min = 50, max = 50000, message = "Please enter a number greater than 50$ and less than 50000$ ")
    @Column(name = "UnitPrice")
    private double UnitPrice;

    @Range(min = 3, max = 50, message = "Please enter a number greater than 3 and less than 50 ")
    @Column(name = "UnitInStock")
    private int UnitInStock;

    @Column(name = "UnitInOrder")
    private int UnitInOrder;

    @Column(name = "Image")
    private String Image;

    @Column(name = "Status")
    private String Status;

    @Column(name = "StatusSale")
    private int StatusSale;

    @Transient
    private MultipartFile FileUpload;

    @ManyToOne
    @JoinColumn(name = "CategorieID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategorieEntity categorie;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private SupplierEntity supplier;

    @OneToOne(mappedBy = "products")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ImageProductEntity imageProduct;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    //@Fetch(FetchMode.SUBSELECT)
    private List<SaleOffEntity> saleOff;

    @OneToMany(mappedBy = "productss", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ShopCartEntity> shopcart;

    @OneToMany(mappedBy = "productod")
    private List<OrderDetailEntity> odDetail;

    @OneToMany(mappedBy = "product")
    private List<WhisListEntity> whislist;

}
