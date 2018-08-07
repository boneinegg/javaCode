package com.liupp.pojo;

import org.springframework.stereotype.Component;

@Component("category")
public class Category {
    private String name = "category_1";
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
