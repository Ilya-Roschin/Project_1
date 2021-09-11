package com.roschin.crud.user.menu;

import com.roschin.crud.user.model.User;
import com.roschin.crud.user.reader.Reader;
import com.roschin.crud.user.storage.UserStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationMenu {

    private static final UserStorage STORAGE = new UserStorage();
    private static final Reader reader = new Reader();

    public void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. add new user");
        System.out.println("2. find user by user name");
        System.out.println("3. delete user by user name");
        System.out.println("4. find all users");
        System.out.println("5. remove user by user name");
        System.out.println("6. remove user by user name");
        System.out.println("0. exit");

    }

    public int readMenu() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void makeChoice(int choice) throws IOException {
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
            case 5:
                updateUser();
                break;
            case 6:
                createNewFileTxt();
            case 0:
                System.exit(0);
            default:
                System.out.println("no such operations");
        }
    }

    private void findUser() {
        String firstName = reader.readLine("Enter user name: ");
        User foundUser = STORAGE.findByFirstName(firstName);
        System.out.println(foundUser);
    }

    private void deleteUser() {
        String name = reader.readLine("Enter user name: ");
        if (STORAGE.deleteByUserName(name)) {
            System.out.println("User deleted");
        } else {
            System.out.println("User not found");
        }
    }

    private void findAllUsers() {
        User[] users = STORAGE.findAll();
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
        String inputName = reader.readLine("input new first name: ");
        String inputEmail = reader.readLine("input new Email: ");
        User user = new User(inputName, inputEmail);
        STORAGE.add(user);
    }

    private void updateUser() {
        String findName = reader.readLine("input user name: ");
        String inputName = reader.readLine("input new first name: ");
        String inputEmail = reader.readLine("input new Email: ");
        long id = STORAGE.findByFirstName(findName).getId();
        User newUser = new User(id, inputName, inputEmail);
        STORAGE.removeUser(findName, newUser);
    }

    private File createNewFileTxt() throws IOException {
        String name = reader.readLine("Enter file name: ");
        File createFile = new File("C:\\projects\\СrudUser\\src\\" +
                "com\\roschin\\crud\\user\\resource\\" + name + ".txt");
        createFile.createNewFile();
        return createNewFileTxt();
    }

    private void addAllUsersToTxt(File createFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(createFile);
        User[] users = STORAGE.findAll();
        for (User element : users) {
            if (element == null) {
                continue;
            }
            pw.println(element);
        }
    }

}
