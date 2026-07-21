package com.urlshrtner.project.mapper;


import org.mapstruct.Mapper;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.model.URLs;


@Mapper(componentModel = "spring")
public interface UrlMapper {
    URLs toEntity(UrlRequest request);
    UrlResponse toResponse(URLs url);
    
}
