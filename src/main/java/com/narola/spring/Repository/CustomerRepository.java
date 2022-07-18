package com.narola.spring.Repository;

import com.narola.spring.Customer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class CustomerRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Customer> getCustomers() {
        Query query = entityManager.createQuery("select c from  Customer c");
        List<Customer> customers= query.getResultList();
        return customers;
    }
}
