package com.example.stripepayments.dto.util;

import com.example.stripepayments.dto.ProductData;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import org.springframework.stereotype.Component;

@Component
public class StripeUtilProduct {
    public ProductData getProductId(String id) throws StripeException {
        Product product =
                Product.retrieve(id);
        ProductData data = setProductData(product);
        return data;
    }

    public ProductData setProductData(Product product) {
        ProductData productData = new ProductData();
        productData.setType(product.getType());
        productData.setId(product.getId());
        productData.setName(product.getName());
        return productData;
    }
}
