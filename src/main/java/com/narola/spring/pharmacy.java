package com.narola.spring;

import javax.persistence.*;

@Entity
@Table(name="pharmacytbl")
public class pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pharmacyId")
    private int pharmacyId;
    @Column(name="name",nullable = false)
    private String pharmacyName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "city", column = @Column(name = "pharmacy_city")),
            @AttributeOverride( name = "street", column = @Column(name = "pharmacy_street")),
            @AttributeOverride( name = "country", column = @Column(name = "pharmacy_country"))
    })
    private Address address;
}
