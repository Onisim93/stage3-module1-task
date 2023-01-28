package com.mjc.school.command.news;

import com.mjc.school.util.MessageHelper;
import com.mjc.school.command.Command;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.dto.NewsDto;

public class UpdateCommand implements Command<NewsController> {
    @Override
    public void execute(NewsController controller) {
        MessageHelper.printMessage("Input news id:");
        long newsId = MessageHelper.readId();
        MessageHelper.printMessage("Input new title:");
        String title = MessageHelper.readString();
        MessageHelper.printMessage("Input new content:");
        String content = MessageHelper.readString();
        MessageHelper.printMessage("Input new author ID:");
        long authorId = MessageHelper.readId();

        NewsDto newsDTO = new NewsDto(newsId, title, content, authorId);

        MessageHelper.printMessage(controller.update(newsDTO).toString());
    }
}
