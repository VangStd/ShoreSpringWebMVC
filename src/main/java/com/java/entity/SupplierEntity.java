/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Supplier")
@Data
public class SupplierEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Length(min = 4,max = 30,message = "Please enter a CompanyName greater than 4 and less than 30 character ")
    private String CompanyName;

    @NotEmpty(message = "Please enter Address * ")
    private String Address;

    @NotEmpty(message = "Please enter City * ")
    private String City;

    @NotEmpty(message = "Please enter Country * ")
    private String Country;

    @Length(min = 10,max = 12,message = "Phone greater than 10 and less than 12 number ")
    private String Phone;

    @NotEmpty(message = "Please enter HomePage * ")
    private String HomePage;

    @OneToMany(mappedBy = "supplier")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ProductEntity> product;

}
