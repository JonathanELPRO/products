package com.example.product.service;

import com.example.product.IProductRepository;
import com.example.product.Query;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllProductService implements Query<Void, List<ProductDto>> {
    private final IProductRepository iProductRepository;


    AllProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public ResponseEntity<List<ProductDto>> execute(Void input) {
        List<Product> products = iProductRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(ProductDto::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

}

//usar Void significa queno se espera un valor de entrada significativo