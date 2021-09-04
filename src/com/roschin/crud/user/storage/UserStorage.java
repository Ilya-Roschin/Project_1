package com.roschin.crud.user.storage;

import com.roschin.crud.user.model.User;

public class UserStorage {

    private static final int ARRAY_SIZE = 10;
    private final User[] storage = new User[ARRAY_SIZE];

    public void add(User user) {
        int indexOfEmptyElement = findIndexOfEmptyElement();
        if (indexOfEmptyElement != -1) {
            storage[indexOfEmptyElement] = user;
        } else {
            System.out.println("no place for users");
        }
    }

    public User findByFirstName(String firstName) {
        int i = 0;
        while (i < ARRAY_SIZE) {
            if (storage[i] == null) {
                i++;
                continue;
            }
            if (storage[i].getFirstName().equals(firstName)) {
                return storage[i];
            }
            i++;
        }
        throw new RuntimeException("There is no user with given username: " + firstName);
    }

    public void deleteByUserName(String firstName) {
        boolean check = true;
        if (firstName != null) {
            int i = 0;
            while (i < ARRAY_SIZE) {
                if (storage[i] == null) {
                    i++;
                    continue;
                }
                if (storage[i].getFirstName().equals(firstName)) {
                    storage[i] = null;
                    System.out.println("User deleted! ");
                    check = false;
                    break;
                }
                i++;
            }
        }
        if (check) {
            System.out.println("User not found! ");
        }
    }

    public User[] findAll() {
        return storage;
    }

    private int findIndexOfEmptyElement() {
        int index = 0;
        while (index < ARRAY_SIZE) {
            if (storage[index] == null) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

