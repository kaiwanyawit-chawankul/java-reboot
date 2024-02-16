package com.example.db.demo;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class Customer {
    @Id
    private @Getter @Setter Long id;

    private @Getter @Setter String firstName;

    private @Getter @Setter String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']",
            id, firstName, lastName);
    }
}
