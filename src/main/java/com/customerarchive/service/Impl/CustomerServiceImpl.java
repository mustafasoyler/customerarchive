package com.customerarchive.service.Impl;

import com.customerarchive.exception.ResourceNotFoundExeption;
import com.customerarchive.model.Customer;
import com.customerarchive.repository.CustomerRepository;
import com.customerarchive.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer existCustomer=customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundExeption("Customer","id","id",id));

        existCustomer.setCustomerName(customer.getCustomerName());
        existCustomer.setCustomerLastName(customer.getCustomerLastName());
        existCustomer.setCustomerEmail(customer.getCustomerEmail());

        customerRepository.save(existCustomer);
        return existCustomer;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundExeption("Customer","id","id",id));

        customerRepository.deleteById(id);

    }
}
