package com.densoft.springcrm.DAO;

import com.densoft.springcrm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        System.out.println("dennis");
        Query<Customer> theQuery  = session.createQuery("from Customer ", Customer.class);

        return theQuery.getResultList();
    }
}