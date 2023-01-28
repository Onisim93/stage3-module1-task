package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.util.SequenceGenerator;

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

    private LoadDataSource(){}

    public static void loadFromFile(List<String> list, String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadData(DataSource dataSource) {

        loadFromFile(authorList, PATH_TO_AUTHORS);
        loadFromFile(titleList, PATH_TO_TITLES);
        loadFromFile(contentList, PATH_TO_CONTENTS);

            for (int i=0; i<20;i++) {
                AuthorModel authorModel = new AuthorModel(SequenceGenerator.getNextSequence(),authorList.get(i));
                dataSource.getAuthorMap().put(authorModel.getId(), authorModel);
                NewsModel newsModel = new NewsModel(SequenceGenerator.getNextSequence(), titleList.get(i), contentList.get(i), authorModel.getId());
                dataSource.getNewsMap().put(newsModel.getId(), newsModel);
            }

     }
}
