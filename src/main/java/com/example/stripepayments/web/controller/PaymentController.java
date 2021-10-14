package com.example.stripepayments.web.controller;

import com.example.stripepayments.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class PaymentController {
    @RequestMapping(value = "/create-payment-intent", method = RequestMethod.POST)//*
    public CreatePaymentResponse createPaymentIntent() throws StripeException {
        List<Object> paymentMethodTypes =
                new ArrayList<>();
        paymentMethodTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("customer", "cus_KGZZtCxrHJqi4d");
        params.put("amount", 2000);
        params.put("currency", "eur");
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );
        // Create a PaymentIntent with the order amount and currency
        PaymentIntent intent = PaymentIntent.create(params);
        return new CreatePaymentResponse(intent.getClientSecret());
    }
}
