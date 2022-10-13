package com.ironhack.Controllers.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class SalesRepresentative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String password;

    @OneToMany(mappedBy = "salesRepresentative")
    private List<Product> products;

    public SalesRepresentative() {
    }

    public SalesRepresentative(String name, String surname, List<Product> products , String password) {
        this.name = name;
        this.surname = surname;
        this.products = products;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
