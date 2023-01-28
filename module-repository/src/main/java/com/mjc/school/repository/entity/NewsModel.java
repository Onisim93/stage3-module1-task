package com.mjc.school.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsModel extends AbstractBaseEntity{
    private String title;
    private String content;
    private LocalDateTime createDate;

    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public NewsModel(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    public NewsModel(Long id, String title, String content, long authorId) {
        super(id);
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }



}
