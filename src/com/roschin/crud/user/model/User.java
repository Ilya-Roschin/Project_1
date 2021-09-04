package com.roschin.crud.user.model;

import java.util.UUID;

public class User {

    private final long id = UUID.randomUUID().getMostSignificantBits();
    private final String firstName;
    private final String email;

    public User(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User ID: " + id + "\n" +
                "User name: " + firstName + "\n" +
                "Email: " + email + "\n" +
                "---------------" + "\n";
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}