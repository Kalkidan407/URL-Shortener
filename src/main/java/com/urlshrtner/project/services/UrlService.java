package com.urlshrtner.project.services;

import org.springframework.stereotype.Service;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor  
public class UrlService {

    private UrlResponse urlrespose;
    private UrlRequest urlRequest;

    

    private UrlResponse toDto(UrlRequest urlRequest) {

        UrlResponse urlResponse = new UrlResponse();
        urlResponse.setOriginalUrl(urlRequest.getOriginalUrl());
        return urlResponse;
    }

    private UrlRequest fromDto( UrlResponse urlResponse) {

        return urlRequest;
    }


    
}
 