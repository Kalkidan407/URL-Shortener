package com.urlshrtner.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.model.URLs;
import com.urlshrtner.project.repositories.UrlRepository;
import com.urlshrtner.project.services.UrlService;

@SpringBootTest
public class UrlServiceIntegrationTest {

   @Autowired
    private UrlService service;

  @Autowired
    private UrlRepository repository;


    @Test
void shouldCreateShortUrlSuccessfully() {

    UrlRequest request = new UrlRequest();
request.setOriginalUrl("https://leetcode.com/");

UrlResponse response = service.createShortURL(request);


assertNotNull(response);
assertNotNull(response.getShortCode());
assertEquals("https://leetcode.com/", response.getOriginalUrl());

URLs savedUrl = repository.findByShortCode(response.getShortCode())
        .orElseThrow();

        assertEquals("https://leetcode.com/", savedUrl.getOriginalUrl());

}
    
}
