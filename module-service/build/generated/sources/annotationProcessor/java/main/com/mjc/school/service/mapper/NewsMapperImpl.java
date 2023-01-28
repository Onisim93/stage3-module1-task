package com.mjc.school.service.mapper;

import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-28T22:45:25+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO toDto(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDTO newsDTO = new NewsDTO();

        newsDTO.setId( news.getId() );
        newsDTO.setTitle( news.getTitle() );
        newsDTO.setContent( news.getContent() );
        newsDTO.setAuthorId( news.getAuthorId() );
        newsDTO.setCreateDate( news.getCreateDate() );
        newsDTO.setLastUpdateDate( news.getLastUpdateDate() );

        return newsDTO;
    }

    @Override
    public News toEntity(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setId( newsDTO.getId() );
        news.setTitle( newsDTO.getTitle() );
        news.setContent( newsDTO.getContent() );
        news.setCreateDate( newsDTO.getCreateDate() );
        news.setLastUpdateDate( newsDTO.getLastUpdateDate() );
        news.setAuthorId( newsDTO.getAuthorId() );

        return news;
    }

    @Override
    public List<NewsDTO> toListDto(List<News> newsList) {
        if ( newsList == null ) {
            return null;
        }

        List<NewsDTO> list = new ArrayList<NewsDTO>( newsList.size() );
        for ( News news : newsList ) {
            list.add( toDto( news ) );
        }

        return list;
    }
}
