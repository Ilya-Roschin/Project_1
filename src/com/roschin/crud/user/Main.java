package com.roschin.crud.user;

import com.roschin.crud.user.model.User;
import com.roschin.crud.user.storage.UserStorage;

import java.util.Scanner;

public class Main {

    private static final UserStorage storage = new UserStorage();

    public static void main(String[] args) {


        while (true) {
            printMenu();
            int choice = readMenu();
            makeChoice(choice);
        }


//
//        Scanner scanner = new Scanner(System.in);
//
//    while (true) {
//        System.out.println("input first name: ");
//        String input = scanner.nextLine();
//        if ("0".equals(input)) {
//            break;
//        }
//        User user = new User(1, input, "email@.com");
//        storage.add(user);
//
//    }
//
//        System.out.println("Enter first name");
//        String findName = scanner.nextLine();
//        storage.findByFirstName(findName);


    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. add new user");
        System.out.println("2. find user by user name");
        System.out.println("3. delete user by user name");
        System.out.println("4. find all users");
        System.out.println("0. exit");

    }

    private static int readMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void makeChoice(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("input first name: ");
                String input = scanner.nextLine();
                if ("0".equals(input)) {
                    break;
                }
                User user = new User(1, input, "email@.com");
                storage.add(user);
                break;

            case 0:
                System.exit(0);
            case 2:
                System.out.println("Enter first name: ");
                String firstName = scanner.nextLine();
                User foundUser = storage.findByFirstName(firstName);
                System.out.println(foundUser.getId());
                System.out.println(foundUser.getFirstName());
                System.out.println(foundUser.getEmail());
                System.out.println();
                break;
            case 3:
                System.out.println("Enter user name: ");
                String name = scanner.nextLine();
                storage.deleteByUserName(name);
                break;

            case 4:
                User[] users = storage.findAll();
                for (User element : users) {
                    if (element == null) {
                        continue;
                    }
                    System.out.println(element.getId());
                    System.out.println(element.getFirstName());
                    System.out.println(element.getEmail());
                    System.out.println("--------------------");
                }
                break;
            default:
                System.out.println("no such operations");
        }
    }


}
// TODO: 31.08.2021  Add git
// TODO Методы, связанные с меню, вынести в класс ApplicationMenu и вызывыть только через объект этого класса
// TODO: 31.08.2021  Нормально вводить юзера (все пол кроме айди)
// TODO:Айди должен автоматически инкрементиться
