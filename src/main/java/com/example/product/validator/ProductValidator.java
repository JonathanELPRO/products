package com.example.product.validator;

import com.example.product.exception.ErrorMessages;
import com.example.product.exception.ProductBadRequestException;
import com.example.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {
    public static void validateProduct(Product product) {
        if (StringUtils.isEmpty(product.getName())) {
            throw new ProductBadRequestException(ErrorMessages.NAME_IS_REQUIRED.toString());
        }
        if (StringUtils.isEmpty(product.getDescription())) {
            throw new ProductBadRequestException(ErrorMessages.DESCRIPTION_IS_REQUIRED.toString());
        }
    }
}