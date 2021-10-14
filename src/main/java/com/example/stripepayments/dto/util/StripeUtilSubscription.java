package com.example.stripepayments.dto.util;

import com.example.stripepayments.dto.SubscriptionData;
import com.stripe.exception.StripeException;
import com.stripe.model.Subscription;
import org.springframework.stereotype.Component;

@Component
public class StripeUtilSubscription {
    public SubscriptionData getSubscriptionId(String id) throws StripeException {
        Subscription subscription =
                Subscription.retrieve(id);
        SubscriptionData data = setSubscriptionData(subscription);
        return data;
    }

    public SubscriptionData setSubscriptionData(Subscription subscription) {
        SubscriptionData subscriptionData = new SubscriptionData();
        subscriptionData.setSubscriptionId(subscription.getId());
        return subscriptionData;
    }
}
