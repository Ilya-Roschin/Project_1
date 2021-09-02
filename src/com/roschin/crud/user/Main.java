package com.roschin.crud.user;

import com.roschin.crud.user.model.User;
import com.roschin.crud.user.storage.UserStorage;
import com.roschin.crud.user.ApplicationMenu;

import java.util.Scanner;

public class Main {

    private static final UserStorage storage = new UserStorage();
    private static final ApplicationMenu menu = new ApplicationMenu();

    public static void main(String[] args) {


//        while (true) {
//            printMenu();
//            int choice = readMenu();
//            makeChoice(choice);
//        }

    }

//    private static void printMenu() {
//        System.out.println("Menu:");
//        System.out.println("1. add new user");
//        System.out.println("2. find user by user name");
//        System.out.println("3. delete user by user name");
//        System.out.println("4. find all users");
//        System.out.println("0. exit");
//
//    }
//
//    private static int readMenu() {
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextInt();
//    }
//
//    private static void makeChoice(int choice) {
//        Scanner scanner = new Scanner(System.in);
//        switch (choice) {
//            case 1:
//                System.out.println("input first name: ");
//                String inputName = scanner.nextLine();
//                if ("0".equals(inputName)) {
//                    break;
//                }
//                System.out.println("input Email: ");
//                String inputEmail = scanner.nextLine();
//                if ("0".equals(inputEmail)) {
//                    break;
//                }
//                int userId = storage.createNewUserId();
//
//                User user = new User(userId, inputName, inputEmail);
//                storage.add(user);
//                break;
//            case 2:
//                System.out.println("Enter first name: ");
//                String firstName = scanner.nextLine();
//                User foundUser = storage.findByFirstName(firstName);
//                System.out.println("User ID:" + foundUser.getId());
//                System.out.println("First name:" + foundUser.getFirstName());
//                System.out.println("Email:" + foundUser.getEmail());
//                System.out.println("--------------------");
//                break;
//            case 3:
//                System.out.println("Enter user name: ");
//                String name = scanner.nextLine();
//                storage.deleteByUserName(name);
//                break;
//
//            case 4:
//                boolean check = true;
//                User[] users = storage.findAll();
//                for (User element : users) {
//                    if (element == null) {
//                        continue;
//                    }
//                    System.out.println("User ID:" + element.getId());
//                    System.out.println("First name:" + element.getFirstName());
//                    System.out.println("Email:" + element.getEmail());
//                    System.out.println("--------------------");
//                    check = false;
//                }
//                if (check) {
//                    System.out.println("No users!");
//                }
//                break;
//            case 0:
//                System.exit(0);
//            default:
//                System.out.println("no such operations");
//        }
//    }


}
// TODO: 31.08.2021  Add git
// TODO Методы, связанные с меню, вынести в класс ApplicationMenu и вызывыть только через объект этого класса
