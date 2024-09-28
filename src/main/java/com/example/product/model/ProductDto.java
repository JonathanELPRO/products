package com.example.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor eso se anota para no escribir el contructor basico que se ve asi:
//public ProductDto(int id, String name, String description) {
//    this.id = id;
//    this.name = name;
//    this.description = description;
//}
@Data
@AllArgsConstructor
public class ProductDto {
    private final int id;
    private final String name;
    private final String description;


    public ProductDto(Product product) {//representacion de la fila de mi base de datos pero en una instancia que si puedo manipular
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }


    public Product toProduct() {//util cuando quiero manipular a mi base de datos, si te das cuenta te retorna un Product que que representa como tal a la base de datos
        //y esta perfecto tener separado algo que represente a la base de datos y algo que me permita manipular esa representacion en este caos el productDto
        var product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        return product;
    }
}
