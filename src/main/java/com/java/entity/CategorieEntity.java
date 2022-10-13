/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author kyqua
 */
@Entity
@Table(name = "Categorie")
@Data
public class CategorieEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @NotEmpty(message = "Please Enter CategorieName * ")
    private String CateName;

    @NotEmpty(message = "Please Enter CategorieDescription * ")
    private String Description;

    @OneToMany(mappedBy = "categorie")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<ProductEntity> product;

    
}
