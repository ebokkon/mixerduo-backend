package com.codecool.mixerduo2.model;

import java.util.UUID;

public class Course {

    private String name;
    private int price;
    private UUID id = UUID.randomUUID();

    public Course(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

