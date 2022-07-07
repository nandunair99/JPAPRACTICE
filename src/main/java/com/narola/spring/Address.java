package com.narola.spring;

import javax.persistence.*;

@Embeddable
@Table(name="addresstbl")
public class Address {

    private String city;
    private String street;
    private String country;

}
