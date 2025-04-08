package com.example.MotoGearHub.repository;


import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<Brand, Long> {

}
