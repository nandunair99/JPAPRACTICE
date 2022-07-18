package com.narola.spring;

import javax.persistence.*;

@Entity
@Table(name="customertbl")
public class Customer {
    @EmbeddedId
    private CustomerID customerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "customer_city")),
            @AttributeOverride( name = "street", column = @Column(name = "customer_street")),
            @AttributeOverride( name = "country", column = @Column(name = "customer_country"))
    })
    private Address address;

    public CustomerID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerID customerId) {
        this.customerId = customerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
