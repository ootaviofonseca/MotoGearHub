package com.example.MotoGearHub.service;

import com.example.MotoGearHub.dto.BrandDTO;
import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    //To convert Brand to BrandDTO
    private List<BrandDTO> convertData(List<Brand> brands){
        return  brands.stream()
                .map(b -> new BrandDTO(b.getName(), b.getCountry(), b.getEmail(), b.getCnpj(), b.getSummary()))
                .collect(Collectors.toList());
    }
    public List<BrandDTO> getAllBrands() {
        return convertData(repository.findAll());
    }
}
