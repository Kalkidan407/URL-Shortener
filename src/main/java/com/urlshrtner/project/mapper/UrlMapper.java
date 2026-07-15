package com.urlshrtner.project.mapper;


import org.mapstruct.Mapper;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.model.Url;

@Mapper(componentModel = "spring")
public interface UrlMapper {

    Url toEntity(UrlRequest request);
    UrlResponse toResponse(Url url);
    
}
