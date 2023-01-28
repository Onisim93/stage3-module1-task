package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T00:46:03+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto toDto(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( newsModel.getId() );
        newsDto.setTitle( newsModel.getTitle() );
        newsDto.setContent( newsModel.getContent() );
        newsDto.setAuthorId( newsModel.getAuthorId() );
        newsDto.setCreateDate( newsModel.getCreateDate() );
        newsDto.setLastUpdateDate( newsModel.getLastUpdateDate() );

        return newsDto;
    }

    @Override
    public NewsModel toEntity(NewsDto newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( newsDTO.getId() );
        newsModel.setTitle( newsDTO.getTitle() );
        newsModel.setContent( newsDTO.getContent() );
        newsModel.setCreateDate( newsDTO.getCreateDate() );
        newsModel.setLastUpdateDate( newsDTO.getLastUpdateDate() );
        newsModel.setAuthorId( newsDTO.getAuthorId() );

        return newsModel;
    }

    @Override
    public List<NewsDto> toListDto(List<NewsModel> newsModelList) {
        if ( newsModelList == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( newsModelList.size() );
        for ( NewsModel newsModel : newsModelList ) {
            list.add( toDto( newsModel ) );
        }

        return list;
    }
}
