package com.mjc.school.service.util;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LoadDataSource {
    private static final String PATH_TO_AUTHORS = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("./author.txt")).getPath();
    private static final String PATH_TO_TITLES = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("./title.txt")).getPath();
    private static final String PATH_TO_CONTENTS = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("./content.txt")).getPath();
    private static final List<String> authorList = new ArrayList<>();
    private static final List<String> titleList = new ArrayList<>();
    private static final List<String> contentList = new ArrayList<>();

    public static void loadDataSource(List<String> list, String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadData() {
        NewsRepository newsRepository = NewsRepository.getInstance();
        AuthorRepository authorRepository = AuthorRepository.getInstance();

        loadDataSource(authorList, PATH_TO_AUTHORS);
        loadDataSource(titleList, PATH_TO_TITLES);
        loadDataSource(contentList, PATH_TO_CONTENTS);

            for (int i=0; i<20;i++) {
                int random = new Random().nextInt(20);
                Author author = authorRepository.create(new Author(authorList.get(i)));
                newsRepository.create(new News(titleList.get(random), contentList.get(random), author.getId()));
            }

    }
}
