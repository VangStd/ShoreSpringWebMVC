/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Orders")
@Data
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderID;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date OrderDate;

    private String PhoneShip;

    private String AddressShip;

    private String Note;

    private String Status;

    @ManyToOne
    @JoinColumn(name = "CusID")
    private CustomerEntity cutomers;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetailEntity> odDetail;
}
