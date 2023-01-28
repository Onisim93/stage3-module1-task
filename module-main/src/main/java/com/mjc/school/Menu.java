package com.mjc.school;

import com.mjc.school.util.MessageHelper;
import com.mjc.school.command.Operation;

public class Menu {
    private StringBuilder listMenu;

    private static Menu instance;

    private Menu(){
        init();
    };

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void init() {
        listMenu = new StringBuilder();
        Operation[] operations = Operation.values();
        for (Operation operation : operations) {
            if (operation == Operation.EXIT) {
                continue;
            }
            listMenu.append(operation.getDescription()).append("\n");
        }
        listMenu.append(Operation.EXIT.getDescription());
    }

    public void print() {
        MessageHelper.printMessage(listMenu.toString());
    }
}
