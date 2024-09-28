package com.example.product.exception;

import org.springframework.http.HttpStatus;
import com.example.product.model.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class) //esto de aqui significa cualquier excepcion del tipo ProductNotFoundException sera manejador por el handle de abajo
    @ResponseBody//lo que retorne el handle se pondra el el cuerpo de la respuesta http que se de
    @ResponseStatus(HttpStatus.NOT_FOUND)//Cuando se retorne una respuesta http se devolvera un codigo 404
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        return new ErrorResponse(productNotFoundException.getMessage());
        //nota que arriba se esta creando una instancia de ErrorResponse pero gracias a @ResponseBody se volvera json eh ira al cuerpo de la respuesta http
    }

    @ExceptionHandler(ProductBadRequestException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleProductBadRequest(ProductBadRequestException productBadRequestException) {
        return new ErrorResponse(productBadRequestException.getMessage());
    }

}
//
//Cuando cualquier parte de tu aplicación lanza una excepción de
//        tipo ProductNotFoundException, el metodo handleProductNotFoundException()
//    la "intercepta" y maneja esa situación, en lugar de dejar que la excepción
//se propague y cause un error interno del servidor.

//@ControllerAdvice es una anotación que convierte la
// clase GlobalExceptionHandler en una clase de manejo de
// excepciones globales. Esto significa que los métodos dentro de
// esta clase se aplicarán a todas las excepciones lanzadas por los
// controladores de la aplicación.
