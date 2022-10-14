package com.densoft.springcrm.service;

import com.densoft.springcrm.entity.Customer;


import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
