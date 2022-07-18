package com.narola.spring;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerID implements Serializable {
    private String name;
    private String phoneNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
