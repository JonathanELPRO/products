package com.example.product.Controller;

import com.example.product.model.ProductDto;
import com.example.product.model.UpdateProductDto;
import com.example.product.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    AllProductService allProductService;
    CreateProductService createProductService;
    GetProductService getProductService;
    UpdateProductService updateProductService;
    DeleteProductService deleteProductService;

    ProductController(AllProductService allProductService,
                      CreateProductService createProductService,
                      GetProductService getProductService,
                      UpdateProductService updateProductService,
                      DeleteProductService deleteProductService) {
        this.allProductService = allProductService;
        this.createProductService = createProductService;
        this.getProductService=getProductService;
        this.updateProductService=updateProductService;
        this.deleteProductService=deleteProductService;
    }


    @PostMapping
    public ResponseEntity<String> create(
            @RequestBody ProductDto productDto
    ) {
        return this.createProductService.execute(productDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> obtain(@PathVariable Integer id) {
        return this.getProductService.execute(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return this.deleteProductService.execute(id);
    }


    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody UpdateProductDto updateProductDto) {
        return this.updateProductService.execute(updateProductDto);
    }


    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        return this.allProductService.execute(null);
    }


}

