package com.example.stripepayments.web.controller;

import com.example.stripepayments.dto.ProductData;
import com.example.stripepayments.dto.util.StripeUtilProduct;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    StripeUtilProduct stripeUtilProduct;
    @RequestMapping(value = "/create-product", method = RequestMethod.POST)//*
    public ProductData createNewProduct(@RequestBody ProductData productData) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", productData.getName());
        params.put("type", productData.getType());
        Product p1 = Product.create(params);
        return productData;
    }

    @RequestMapping("/getAll-products")
    public List<ProductData> getAllProducts() throws StripeException {
        Map<String, Object> params = new HashMap<>();
        ProductCollection products = Product.list(params);
        List<ProductData> allProducts = new ArrayList<ProductData>();
        for(int i = 0; i < products.getData().size(); i++) {
            ProductData productData = new ProductData();
            productData.setType(products.getData().get(i).getType());
            productData.setName(products.getData().get(i).getName());
            productData.setId(products.getData().get(i).getId());
            allProducts.add(productData);
        }
        return allProducts;
    }

    @RequestMapping("/delete-product/{id}")//*
    public String deleteProduct(@PathVariable("id")String id) throws StripeException{
        Product product =
                Product.retrieve(id);
        Product deletedProduct = product.delete();
        return "successfully deleted";
    }

    @RequestMapping("/get-productByID/{id}")
    public ProductData getProductByID(@PathVariable("id")String id) throws StripeException{
        ProductData output = stripeUtilProduct.getProductId(id);
        return output;
    }

    @RequestMapping(value = "/update-productByID/{id}", method = RequestMethod.PATCH)//*
    public ProductData updateProductByID(@RequestBody ProductData data,
                                           @PathVariable("id")String id) throws StripeException{
        Product product =
                Product.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("name", data.getName());
        Product updatedProduct = product.update(params);
        return data;
    }
}
