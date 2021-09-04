package com.roschin.crud.user.model;

public class User {

    private final int id;
    private final String firstName;
    private final String email;

    public User(int id, String firstName, String email) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }
}