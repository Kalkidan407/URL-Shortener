package com.urlshrtner.project;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.model.URLs;
import com.urlshrtner.project.repositories.UrlRepository;
import com.urlshrtner.project.services.UrlService;

@SpringBootTest
@ActiveProfiles("test")
class UrlServiceIntegrationTest {

   @Autowired
    private UrlService service;

  @Autowired
    private UrlRepository repository;


@Test
void shouldCreateShortUrl() {

     UrlRequest request = new UrlRequest();
     UrlResponse response = service.createShortURL(request);

     request.setOriginalUrl("https://google.com");
     request.setSiteName("Google");

     assertNotNull(response.getId());
     assertNotNull(response.getShortCode());

     URLs savedUrl = repository.findById(response.getId())
            .orElseThrow();

     assertEquals(
        "https://google.com",
        savedUrl.getOriginalUrl()
    );

}

    
}
