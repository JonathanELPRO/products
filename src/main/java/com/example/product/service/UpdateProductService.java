package com.example.product.service;

import com.example.product.Command;
import com.example.product.IProductRepository;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import com.example.product.model.UpdateProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductDto, ProductDto> {


    private final IProductRepository iProductRepository;


    UpdateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public ResponseEntity<ProductDto> execute(UpdateProductDto input) {
        Optional<Product> product = iProductRepository.findById(input.getId());


        if(product.isPresent()) {
            product.get().setDescription(input.getProductDto().getDescription());
            product.get().setName(input.getProductDto().getName());

            Product updatedProduct = iProductRepository.save(product.get());
            ProductDto updatedProductDto = new ProductDto(updatedProduct);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProductDto);



            //return new ProductDto(iProductRepository.save(product.get()));
            //la linea de arriba retornaba un product en el save y se casteaba a ProductDto tranquilamente podia hacer
            //return ResponseEntity.status(HttpStatus.OK).body(new ProductDto(iProductRepository.save(product.get())));
        }
        throw new ProductNotFoundException();



    }
}
