package com.roschin.crud.user.storage;

import com.roschin.crud.user.model.User;

import java.util.Random;

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

    public User findByFirstName(String firstName) {
        if (firstName != null) {
            int i = 0;
            while (i < ARRAY_SIZE) {
                if (storage[i] == null) {
                    i++;
                    continue;
                }
                if (firstName.equals(storage[i].getFirstName())) {
                   return storage[i];
                }
                i++;
            }
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

    public int createNewUserId() {
        Random random = new Random();
        boolean check;
        int newUserIndex;
        do {
            check = false;
            newUserIndex = 100000 + random.nextInt(899999);
            for (User element : storage) {
                if (element == null) {
                    continue;
                }
                if (element.getId() == newUserIndex) {
                    check = true;
                    break;
                }
            }
        } while (check);
        return newUserIndex;
    }

    public User[] findAll() {
        return storage;
    }

}
