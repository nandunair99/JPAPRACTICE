package com.narola.spring;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "addresstbl")
public class Address {

    private String city;
    private String street;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
