package com.narola.spring;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catId")
    private int categoryID;
    @Column(name="catName",unique = true,nullable = false)
    private String categoryName;

    @OneToMany( mappedBy = "category")
    private List<Medicine> medicine=new ArrayList<>();

    public int getID() {
        return categoryID;
    }

    public void setID(int ID) {
        this.categoryID = ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}