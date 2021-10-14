package com.example.stripepayments.dto.util;

import com.example.stripepayments.dto.CustomerData;
import com.example.stripepayments.dto.PriceData;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Plan;
import com.stripe.model.Price;
import org.springframework.stereotype.Component;

@Component
public class StripeUtilPrice {
    public PriceData getPrice(String id) throws StripeException {
        Plan plan =
                Plan.retrieve(id);
        PriceData data = setPriceData(plan);
        return data;
    }

    public PriceData setPriceData(Plan plan) {
        PriceData priceData = new PriceData();
        priceData.setId(plan.getId());
        priceData.setAmount(plan.getAmount());
        priceData.setCurrency(plan.getCurrency());

        return priceData;
    }
}
