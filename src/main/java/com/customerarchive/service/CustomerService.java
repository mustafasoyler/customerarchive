package com.customerarchive.service;

import com.customerarchive.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer,Long id);
    void deleteCustomer(Long id);
}
