package com.roschin.crud.user;

import com.roschin.crud.user.storage.UserStorage;

public class Main {

    private static final UserStorage storage = new UserStorage();


    public static void main(String[] args) {

        while (true) {
            ApplicationMenu.printMenu();
            int choice = ApplicationMenu.readMenu();
            ApplicationMenu.makeChoice(choice);
        }
    }

}



// TODO: 31.08.2021  Add git
// TODO Методы, связанные с меню, вынести в класс ApplicationMenu и вызывыть только через объект этого класса
