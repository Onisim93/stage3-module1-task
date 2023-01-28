package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
    NewsDto toDto (NewsModel newsModel);
    NewsModel toEntity (NewsDto newsDTO);

    List<NewsDto> toListDto (List<NewsModel> newsModelList);
}
