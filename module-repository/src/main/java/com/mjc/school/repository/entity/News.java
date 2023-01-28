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
public class News extends AbstractBaseEntity{
    private String title;
    private String content;
    private LocalDateTime createDate;

    private LocalDateTime lastUpdateDate;
    private Long authorId;

    public News(String title, String content, long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }



}
