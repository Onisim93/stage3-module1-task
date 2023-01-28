package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataSource {
    private final Map<Long, AuthorModel> authorMap;
    private final Map<Long, NewsModel> newsMap;
    private static DataSource instance;

    private DataSource() {
        authorMap = new ConcurrentHashMap<>();
        newsMap = new ConcurrentHashMap<>();
        LoadDataSource.loadData(this);
    }

    public static DataSource getInstance() {
        if (instance  == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Map<Long, AuthorModel> getAuthorMap() {
        return authorMap;
    }

    public Map<Long, NewsModel> getNewsMap() {
        return newsMap;
    }
}
