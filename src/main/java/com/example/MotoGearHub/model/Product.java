package com.example.MotoGearHub.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id  AUTOINCREMENT
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory category;

    private String color;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(length = 1000)
    private String description;

    @ManyToOne //Many products can belong to one brand
    private Brand brand;

    public Brand getBrand(){
        return brand;
    }

    public void setBrand(Brand brand){
        this.brand = brand;
    }

    public Product() {
    }

    public Product( String name, ProductCategory category, String color, Integer stockQuantity, BigDecimal price, String description) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", category=" + category +
                ", color='" + color + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", brand=" + brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
