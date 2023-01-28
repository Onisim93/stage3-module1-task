package com.mjc.school.command.news;

import com.mjc.school.util.MessageHelper;
import com.mjc.school.command.Command;
import com.mjc.school.controller.impl.NewsController;

public class DeleteCommand implements Command<NewsController> {
    @Override
    public void execute(NewsController controller) {
        MessageHelper.printMessage("Input news id for remove:");
        long id = MessageHelper.readId();
        MessageHelper.printMessage(controller.delete(id).toString());
    }
}
