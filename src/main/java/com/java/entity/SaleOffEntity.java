/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.Date;
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
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "SaleOff")
@Data
public class SaleOffEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Range(min = 5,max = 70,message = "Percent min 5% and max 70% ")
    private int Percents;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date BeginDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date EndDate;

    private String Status;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private ProductEntity products;
    
}
