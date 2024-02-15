package com.example.demo.domain;

public class Address {
    private String street;
    private int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public Object getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    // getters and setters
}