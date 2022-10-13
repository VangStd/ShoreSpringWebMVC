/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "ShopCart")
@Data
public class ShopCartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Dates")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Dates;

    @Column(name = "Status")
    private String Status;

    @ManyToOne
    @JoinColumn(name = "CusID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CustomerEntity customers;

    @ManyToOne
    @JoinColumn(name = "ProID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductEntity productss;

}
