package com.densoft.springcrm.DAO;

import com.densoft.springcrm.entity.Customer;
import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerId);

    void deleteCustomer(int customerId);

    List<Customer> searchCustomers(String theSearchName);
}
