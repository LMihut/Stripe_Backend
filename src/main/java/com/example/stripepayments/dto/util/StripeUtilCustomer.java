package com.example.stripepayments.dto.util;

import com.example.stripepayments.dto.CustomerData;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class StripeUtilCustomer {
    public CustomerData getCustomer(String id) throws StripeException {
        Customer customer =
                Customer.retrieve(id);
        CustomerData data = setCustomerData(customer);
        return data;
    }

    public CustomerData setCustomerData(Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setCustomerId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setEmail(customer.getEmail());

        return customerData;
    }
}
