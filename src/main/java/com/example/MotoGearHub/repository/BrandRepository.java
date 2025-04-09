package com.example.MotoGearHub.repository;


import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.model.Product;
import com.example.MotoGearHub.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByNameContainingIgnoreCase(String nameBrand);

    @Query("SELECT p FROM Product p WHERE p.brand = :brand")
    List<Product> findByBrand(Brand brand);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product>  listProductsByCategory(ProductCategory category);
}
