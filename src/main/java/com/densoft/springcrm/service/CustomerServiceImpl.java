package com.densoft.springcrm.service;

import com.densoft.springcrm.DAO.CustomerDAO;
import com.densoft.springcrm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Transactional
    @Override
    public void deleteCustomer(int customerId) {
        customerDAO.deleteCustomer(customerId);
    }
}
