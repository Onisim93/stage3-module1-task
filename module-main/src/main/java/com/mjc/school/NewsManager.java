package com.mjc.school;

import com.mjc.school.command.news.NewsCommandExecutor;
import com.mjc.school.util.MessageHelper;
import com.mjc.school.controller.NewsController;
import com.mjc.school.command.Operation;
import com.mjc.school.service.util.LoadDataSource;

import java.io.IOException;


public class NewsManager {
    private static NewsManager manager;
    private final NewsController controller;
    private final Menu menu;

    private NewsManager() {
        controller = NewsController.getInstance();
        menu = Menu.getInstance();
        LoadDataSource.loadData();
    }

    public static NewsManager getInstance() {
        if (manager == null) {
            manager = new NewsManager();
        }
        return manager;
    }


    public void init() {
        while (true) {
            menu.print();
            try {
                int input = MessageHelper.readOperation();
                Operation operation = Operation.values()[input];
                NewsCommandExecutor.executeCommand(operation, controller);
            }
            catch (IOException e) {
                MessageHelper.printMessage("Invalid command.");
            }
        }
    }



}

