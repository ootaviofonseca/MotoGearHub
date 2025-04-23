package com.example.MotoGearHub.controller;

import com.example.MotoGearHub.dto.BrandDTO;
import com.example.MotoGearHub.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
