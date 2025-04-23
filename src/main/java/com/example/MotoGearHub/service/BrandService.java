package com.example.MotoGearHub.service;

import com.example.MotoGearHub.dto.BrandDTO;
import com.example.MotoGearHub.dto.ProductDTO;
import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.model.Product;
import com.example.MotoGearHub.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    //To convert Brand to BrandDTO
    private List<BrandDTO> convertData(List<Brand> brands){
        return  brands.stream()
                .map(b -> new BrandDTO(b.getId(), b.getName(), b.getCountry(), b.getEmail(), b.getCnpj(), b.getSummary()))
                .collect(Collectors.toList());
    }
    public List<BrandDTO> getAllBrands() {
        return convertData(repository.findAll());
    }

    public BrandDTO getBrandById(long brand_id) {
        Optional<Brand> brand = repository.findById(brand_id);

        if (brand.isPresent()){
            Brand b = brand.get();
            return new BrandDTO(b.getId(), b.getName(), b.getCountry(), b.getEmail(), b.getCnpj(), b.getSummary());
        }

        return null;
    }

    public List<ProductDTO> getBrandProducts(long brand_id) {
        Optional<Brand> brand = repository.findById(brand_id);

        if (brand.isPresent()){
            Brand b = brand.get();
            return b.getProducts().stream()
                    .map(p->new ProductDTO(
                            p.getId(),
                            p.getName(),
                            p.getCategory(),
                            p.getColor(),
                            p.getStockQuantity(),
                            p.getPrice()))
                    .collect(Collectors.toList());
        }
        return  null;
    }


    public ProductDTO getProductByID(long brand_Id, long product_Id) {

        Optional<Product> product = repository.findProductById(brand_Id, product_Id);

        if(product.isPresent()){
            Product p = product.get();
            return new ProductDTO(
                            p.getId(),
                            p.getName(),
                            p.getCategory(),
                            p.getColor(),
                            p.getStockQuantity(),
                            p.getPrice());
        }

        return null;
    }
}
