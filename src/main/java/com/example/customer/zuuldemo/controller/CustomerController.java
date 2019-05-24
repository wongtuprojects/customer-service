package com.example.customer.zuuldemo.controller;

import com.example.customer.zuuldemo.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @RequestMapping(value = "/getCustomers/{id}")
    public Customer getCustomer(@PathVariable(name = "id") String id) {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setFirstName("TestName");
        customer.setLastName("TestLastName");
        customer.setAge("34");
        return customer;
    }

    @RequestMapping(value="/getCustomers")
    public List<Customer> getCustomers() {
        Customer customer1 = new Customer();
        customer1.setId("1");
        customer1.setFirstName("TestName");
        customer1.setLastName("TestLastName");
        customer1.setAge("34");

        Customer customer2 = new Customer();
        customer2.setId("1");
        customer2.setFirstName("TestName");
        customer2.setLastName("TestLastName");
        customer2.setAge("34");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        return customerList;

    }
}
