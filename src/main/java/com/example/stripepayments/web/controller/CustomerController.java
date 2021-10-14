package com.example.stripepayments.web.controller;

import com.example.stripepayments.dto.CustomerData;
import com.example.stripepayments.dto.util.StripeUtilCustomer;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    StripeUtilCustomer stripeUtil;
    @RequestMapping("/create-customer")//*
    public CustomerData createNewCustomer(@RequestBody CustomerData data) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("name", data.getName());
        params.put("email", data.getEmail());
        Customer customer = Customer.create(params);
        data.setCustomerId(customer.getId());
        return data;
    }

    @RequestMapping("/getAll-customer")//*
    public List<CustomerData> getAllCustomer() throws StripeException {
        Map<String, Object> params = new HashMap<>();

        CustomerCollection customers = Customer.list(params);
        List<CustomerData> allCustomers = new ArrayList<CustomerData>();
        for(int i = 0; i < customers.getData().size(); i++) {
            CustomerData customerData = new CustomerData();
            customerData.setCustomerId(customers.getData().get(i).getId());
            customerData.setEmail(customers.getData().get(i).getEmail());
            customerData.setName(customers.getData().get(i).getName());
            allCustomers.add(customerData);
        }
        return allCustomers;
    }

    @RequestMapping("/delete-customer/{id}")//*
    public String deleteCustomer(@PathVariable("id")String id) throws StripeException{
        Customer customer =
                Customer.retrieve(id);
        Customer deletedCustomer = customer.delete();
        return "successfully deleted";
    }

    @RequestMapping("/get-customerByID/{id}")
    public CustomerData getCustomerByID(@PathVariable("id")String id) throws StripeException{
        CustomerData output = stripeUtil.getCustomer(id);
        return output;
    }

    @RequestMapping(value = "/update-customerByID/{id}", method = RequestMethod.PATCH)//*
    public CustomerData updateCustomerByID(@RequestBody CustomerData data,
                                           @PathVariable("id")String id) throws StripeException{
        Customer customer =
                Customer.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("name", data.getName());
        params.put("email", data.getEmail());
        Customer updatedCustomer = customer.update(params);
        return data;
    }
}
