package com.example.stripepayments.web.controller;

import com.example.stripepayments.dto.SubscriptionData;
import com.example.stripepayments.dto.util.StripeUtilSubscription;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SubscriptionController {
    @Autowired
    StripeUtilSubscription stripeUtilSubscription;

    @Value("${stripe.api.price.id_starter}")
    private String id_starter;
    //@Value("${stripe.api.customer.id}")
    String customerId = "cus_KGZaADG3hSwMRU";

    @RequestMapping("/create-subscribtion")
    public void createSubscriber(@RequestBody SubscriptionData data) throws StripeException {
        Map<String, Object> prodParam = new HashMap<>();
        prodParam.put("price", id_starter);

        Map<String, Object> items = new HashMap<>();
        items.put("0", prodParam);

        Map<String, Object> param = new HashMap<>();
        param.put("items", items);
        param.put("customer", customerId);

        Subscription subscription = Subscription.create(param);
        data.setCustomerId(customerId);
        data.setPriceId(id_starter);
        data.setSubscriptionId(subscription.getId());
    }

    @RequestMapping("/getAll-subscriptions")//*
    public List<SubscriptionData> getSubscriptions() throws StripeException {
        Map<String, Object> params = new HashMap<>();

        SubscriptionCollection subscriptions = Subscription.list(params);
        List<SubscriptionData> allSubscribtion = new ArrayList<SubscriptionData>();
        for(int i = 0; i < subscriptions.getData().size(); i++) {
            SubscriptionData subscriptionData = new SubscriptionData();
            subscriptionData.setSubscriptionId(subscriptions.getData().get(i).getId());
            subscriptionData.setPriceId(id_starter);
            subscriptionData.setCustomerId(customerId);
            allSubscribtion.add(subscriptionData);
        }
        return allSubscribtion;
    }

    @RequestMapping("/delete-subscription/{id}")//*
    public String deleteSubscription(@PathVariable("id")String id) throws StripeException{
        Subscription subscription =
                Subscription.retrieve(id);
        Subscription deleteSubscription = subscription.cancel();
        return "successfully canceled";
    }

    @RequestMapping("/get-subscriptionByID/{id}")
    public SubscriptionData getProductByID(@PathVariable("id")String id) throws StripeException{
        SubscriptionData output = stripeUtilSubscription.getSubscriptionId(id);
        return output;
    }
}
