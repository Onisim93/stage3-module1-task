package com.mjc.school.service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewsDTO{
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;

    public NewsDTO(String title, String content, Long authorId) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }

    public NewsDTO(Long id, String title, String content, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createDate = LocalDateTime.now();
        this.lastUpdateDate = LocalDateTime.now();
    }
}
