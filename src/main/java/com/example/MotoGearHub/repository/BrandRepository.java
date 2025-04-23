package com.example.MotoGearHub.repository;


import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.model.Product;
import com.example.MotoGearHub.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByNameContainingIgnoreCase(String nameBrand);

    ///@Query("SELECT p FROM Brand b JOIN b.products b WHERE b.id = :brand_id")
    //List<Product> findByBrand(@Param("brand_id") Long brand_id);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product>  listProductsByCategory(ProductCategory category);


    @Query("SELECT p FROM Product p WHERE p.brand.id = :brandId AND p.id = :productId")
    Optional <Product > findProductById(long brandId, long productId);
}
