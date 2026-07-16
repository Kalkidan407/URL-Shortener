package com.urlshrtner.project.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.mapper.UrlMapper;
import com.urlshrtner.project.model.URLs;
import com.urlshrtner.project.repositories.UrlRepository;
import com.urlshrtner.project.utility.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor() 
public class UrlService {

    private final  UrlRepository repository;
    private final UrlMapper mapper;
    private final ShortCodeGenerator generate;
    
     String shortCode;

     public UrlResponse createShortURL(UrlRequest request ){
       URLs url = mapper.toEntity(request);
       do{
          shortCode  = generate.generate();
       } while(repository.existsByShortCode(shortCode));

       url.setShortCode(shortCode);
       repository.save(url);
       return mapper.toResponse(url);

      }

      public UrlResponse  getShoerCodeById(UUID id){
           URLs url = repository.findById(id)
                     .orElseThrow(); 
        return  new UrlResponse(
            url.getShortCode(),
            url.getOriginalUrl(),
            url.getClickCount(),
            url.getCreatedAt()
        );

      }


 }
