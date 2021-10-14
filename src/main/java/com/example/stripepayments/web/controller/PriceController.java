package com.example.stripepayments.web.controller;

import com.example.stripepayments.dto.PriceData;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PriceController {
    @RequestMapping(value = "/create-price/{id}")//*
    public PriceData createProductPlan(@RequestBody PriceData priceData, @PathVariable("id")String id) throws StripeException {
        Map<String, Object> planParams = new HashMap<>();
        planParams.put("amount", priceData.getAmount());
        planParams.put("interval", priceData.getInterval());
        planParams.put("currency", priceData.getCurrency());
        planParams.put("product", id);
        Plan p2 = Plan.create(planParams);
        return priceData;
    }

    @RequestMapping("/getAll-prices")
    public List<PriceData> getAllPrices() throws StripeException {
        Map<String, Object> planParams = new HashMap<>();
        PlanCollection plan = Plan.list(planParams);
        List<PriceData> allProducts = new ArrayList<PriceData>();
    for(int i = 0; i < plan.getData().size(); i++) {
        PriceData priceData = new PriceData();
        priceData.setAmount(plan.getData().get(i).getAmount());
        priceData.setCurrency(plan.getData().get(i).getCurrency());
        priceData.setInterval(plan.getData().get(i).getInterval());
        priceData.setId(plan.getData().get(i).getId());
        allProducts.add(priceData);
        }
        return allProducts;
    }

    @RequestMapping("/delete-price/{id}")//*
    public String deletePrice(@PathVariable("id")String id) throws StripeException{
        Plan plan =
                Plan.retrieve(id);
        Plan deletedPlan = plan.delete();
        return "successfully deleted";
    }

}
