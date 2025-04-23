package com.example.MotoGearHub.dto;

import com.example.MotoGearHub.model.ProductCategory;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        ProductCategory category,
        String color,
        Integer stockQuantity,
        BigDecimal price
) {}
