package com.example.product;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
}

//este repositorio esta heredandotodo de otro repositorio del tipo JPA
//como es un reposiorio generico  que nos poprociona metodos CRUD hay que mandarle
//sobre que tabla o en este caso sobre qu eentity (Product) haremos el crud y mas de paso
//hay que decirle de que tipo es su ID en este caos integer

