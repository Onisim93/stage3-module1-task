package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    NewsDTO toDto (News news);
    News toEntity (NewsDTO newsDTO);

    List<NewsDTO> toListDto (List<News> newsList);
}
