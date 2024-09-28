package com.example.product.model;

import jakarta.persistence.*;
import lombok.Data;

//el entity es para mapear cada instancia de esta clase a una fila de una base de datos
//@Data Esta es una anotación de Lombok que genera automáticamente
// los métodos getter y setter, así como el metodo toString(),
//  equals(), y hashCode() para todos los campos de la clase
//@Table es para mapear la clase con una tabla de base de datos
//@GeneratedValue(strategy = GenerationType. IDENTITY) y el @Id dice que ese atributo de la clase
//sera la clave primaria o id de cada registro en mi tabla y la forma de generarlo estara a cargo de la base de datos y CREARE ID's cada vez totalmente diferentes
@Entity
@Data
@Table( name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column ( name = "id")
    private Integer id;
    @Column ( name = "name")
    private String name;
    @Column ( name = "description")
    private String description;
}
