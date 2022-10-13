package com.ironhack.Controllers.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.math.*;

@Entity
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @Digits(integer = 4, fraction = 2)
    @DecimalMin(value = "9.99")
    private BigDecimal price;
    @Min(0)
    @Max(9999)
    private Long stock;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sales_rep_id")
    private SalesRepresentative salesRepresentative;


    public Product() {
    }

    public Product(String name, BigDecimal price, Long stock, Category category, Genre genre) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.genre = genre;
    }

    public Product(String name, BigDecimal price, Long stock, Category category, Genre genre, SalesRepresentative
                   salesRepresentative) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.genre = genre;
        this.salesRepresentative = salesRepresentative;
    }

    public SalesRepresentative getSalesRepresentative() {
        return salesRepresentative;
    }

    public void setSalesRepresentative(SalesRepresentative salesRepresentative) {
        this.salesRepresentative = salesRepresentative;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


}

