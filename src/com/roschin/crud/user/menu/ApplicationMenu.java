package com.roschin.crud.user.menu;

import com.roschin.crud.user.model.User;
import com.roschin.crud.user.storage.UserStorage;

import java.util.Scanner;

public class ApplicationMenu {

    private static final UserStorage storage = new UserStorage();

    public void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. add new user");
        System.out.println("2. find user by user name");
        System.out.println("3. delete user by user name");
        System.out.println("4. find all users");
        System.out.println("0. exit");

    }

    public int readMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void makeChoice(int choice) {
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                findUser();
                break;
            case 3:
                deleteUser();
                break;
            case 4:
                findAllUsers();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("no such operations");
        }
    }

    private void findUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        User foundUser = storage.findByFirstName(firstName);
        System.out.println(foundUser);
    }

    private void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String name = scanner.nextLine();
        storage.deleteByUserName(name);
    }

    private void findAllUsers() {
        User[] users = storage.findAll();
        for (User element : users) {
            if (element == null) {
                continue;
            }
            System.out.println(element);
        }
        if (users.length == 0) {
            System.out.println("No users!");
        }
    }

    private void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input first name: ");
        String inputName = scanner.nextLine();
        System.out.println("input Email: ");
        String inputEmail = scanner.nextLine();
        int userId = storage.createNewUserId();
        User user = new User(userId, inputName, inputEmail);
        storage.add(user);
    }
}
