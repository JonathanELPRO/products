package com.example.product.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    NAME_IS_REQUIRED("Name is required"),
    DESCRIPTION_IS_REQUIRED("Description is required");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }

}
