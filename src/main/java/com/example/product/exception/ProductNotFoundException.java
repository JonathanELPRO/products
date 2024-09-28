package com.example.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.toString());
    }
}

//Exactamente. super("Product Not Found") invoca al
//constructor de la clase padre (RuntimeException en este caso)
//y le envía el mensaje "Product Not Found".
