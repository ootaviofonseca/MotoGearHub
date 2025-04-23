package com.example.MotoGearHub.model;

import com.example.MotoGearHub.service.OpenAIQuery;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id  AUTOINCREMENT
    private Long id;

    @Column(unique = true)
    private String name;

    private String country;

    private String email;


    private String cnpj;
    @Column(length = 1000)
    private String summary;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (this.products == null) {
            this.products = new ArrayList<>();
        }
        this.products.add(product);
    }


    public Brand(){} //Default constructor

    public Brand(String name, String country, String email, String cnpj){
        this.name = name;
        this.country = country;
        this.email = email;
        this.cnpj = cnpj;
        this.summary = OpenAIQuery.getBrandInfo(name); // Generate on OpenAI


    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", summary='" + summary + '\'' ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
