package com.roschin.crud.user;

public class Main {

    public static void main(String[] args) {

        ApplicationMenu applicationMenu = new ApplicationMenu();
        while (true) {
            try {
                applicationMenu.printMenu();
                int choice = applicationMenu.readMenu();
                applicationMenu.makeChoice(choice);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}


// TODO: 31.08.2021  Add git
// TODO Методы, связанные с меню, вынести в класс ApplicationMenu и вызывыть только через объект этого класса
