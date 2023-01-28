package com.mjc.school.service.validation;

import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.ErrorNotification;

public class NewsValidator {

    private static final String TITLE_NO_VALID = "ERROR_CODE: 000003 News title field should have length of value from 5 to 30.";
    private static final String CONTENT_NO_VALID = "ERROR_CODE: 000004 News content field should have length of value from 5 to 255.";

    public static boolean isNew (NewsDTO news) {
        return news.getId() == null;
    }

    public static ErrorNotification validate (NewsDTO news) {
        ErrorNotification errorNotification = new ErrorNotification();

        String title = news.getTitle();
        String content = news.getContent();

        if (title.length() < 5 || title.length() > 30) errorNotification.addError(TITLE_NO_VALID + " Title length is " + title.length() + ".");

        if (content.length() < 5 || content.length() > 255) errorNotification.addError(CONTENT_NO_VALID + " Content length is " + content.length() + ".");

        return errorNotification;
    }


}
