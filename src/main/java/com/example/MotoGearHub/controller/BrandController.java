package com.example.MotoGearHub.controller;

import com.example.MotoGearHub.dto.BrandDTO;
import com.example.MotoGearHub.dto.ProductDTO;
import com.example.MotoGearHub.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brands") //
public class BrandController {
    @Autowired
    private BrandService service;

    @GetMapping
    public List<BrandDTO> getAllBrands(){
        return service.getAllBrands();
    }

    @GetMapping("/{brand_id}")
    public BrandDTO getBrandById(@PathVariable long brand_id){
        return service.getBrandById(brand_id);
    }

    @GetMapping("/{brand_id}/products")
    public List<ProductDTO> getBrandProducts(@PathVariable long brand_id){
        return service.getBrandProducts(brand_id);
    }

    @GetMapping("/{brand_id}/products/{product_id}")
    public ProductDTO getProductByID(@PathVariable long brand_id, @PathVariable long product_id){
        return service.getProductByID(brand_id,product_id);
    }
}
