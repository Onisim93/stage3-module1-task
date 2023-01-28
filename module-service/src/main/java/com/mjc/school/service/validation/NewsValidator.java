package com.mjc.school.service.validation;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.ErrorNotification;

public class NewsValidator {

    private final String TITLE_NO_VALID = "ERROR_CODE: 000003 News title field should have length of value from 5 to 30.";
    private final String CONTENT_NO_VALID = "ERROR_CODE: 000004 News content field should have length of value from 5 to 255.";
    private final String AUTHOR_NOT_FOUND = "ERROR_CODE: 000001 Author with id %d does not exist.";

    private final AuthorRepository authorRepository;

    public NewsValidator() {
        authorRepository = new AuthorRepository();
    }

    public ErrorNotification validate (NewsDto news) {
        ErrorNotification errorNotification = new ErrorNotification();

        String title = news.getTitle();
        String content = news.getContent();
        Long authorId = news.getAuthorId();

        if (title.length() < 5 || title.length() > 30) errorNotification.addError(TITLE_NO_VALID + " Title length is " + title.length() + ".");

        if (content.length() < 5 || content.length() > 255) errorNotification.addError(CONTENT_NO_VALID + " Content length is " + content.length() + ".");

        if (authorRepository.readById(authorId) == null) {
            errorNotification.addError(String.format(AUTHOR_NOT_FOUND, authorId));
        }

        return errorNotification;
    }


}
