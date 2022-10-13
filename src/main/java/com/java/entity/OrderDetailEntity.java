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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "OrderDetails")
@Data
public class OrderDetailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private int Quantity;

    private double UnitPrice;

    private double Discount;

    private double PriceDisCount;

    private double TotalPrice;

    @ManyToOne
    @JoinColumn(name = "ProID")
    private ProductEntity productod;

    @ManyToOne
    @JoinColumn(name = "OrderID")
    private OrderEntity orders;
}
