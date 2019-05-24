package com.example.customer.zuuldemo.controller;

import com.example.customer.zuuldemo.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void getCustomerId_return_customerBody() throws Exception {
        Customer customer = new Customer();
        customer.setId("1");
        customer.setFirstName("TestName");
        customer.setLastName("TestLastName");
        customer.setAge("34");

        mvc.perform(get("/getCustomers/1")).andExpect(status().isOk())
                .andExpect(jsonPath("firstName", is(customer.getFirstName())));


    }

    @Test
    public void getCustomers_customersBody() throws Exception {
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

        mvc.perform(get("/getCustomers")).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is(customerList.get(0).getFirstName())));

    }


}
