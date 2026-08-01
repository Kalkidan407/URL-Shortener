package com.urlshrtner.project.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.exception.UrlNotFoundException;
import com.urlshrtner.project.model.URLs;
import com.urlshrtner.project.repositories.UrlRepository;
import com.urlshrtner.project.mapper.UrlMapper;
import com.urlshrtner.project.utility.ShortCodeGenerator;

@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @Mock
    private UrlRepository repository;

    @Mock
    private UrlMapper mapper;

    @Mock
    private ShortCodeGenerator generate;

    @InjectMocks
    private UrlService service;

   @Test
    void shouldReturnOriginalUrlWhenShortCodeExists(){

        URLs url = new URLs();
        url.setShortCode("JHS7Vr");
        url.setClickCount(0L);
        url.setOriginalUrl("https://leetcode.com/u/Kalkidan-Kelemework/");

        when(repository.findByShortCode("JHS7Vr") )
            .thenReturn(Optional.of(url));

      String result = service.redirect("JHS7Vr");
    
    assertEquals(1L, url.getClickCount());  //checks the state of the object
    assertEquals("https://leetcode.com/u/Kalkidan-Kelemework/", result);
    verify(repository).save(url); // this checks the behavior or interaction

    }

    @Test
void shouldThrowUrlNotFoundExceptionWhenShortCodeDoesNotExist() {

    when(repository.findByShortCode("abc123"))
            .thenReturn(Optional.empty());

    assertThrows(
        UrlNotFoundException.class,
            () -> service.redirect("abc123")
    );

    verify(repository, never()).save(any());
}


@Test
void shouldIncreaseClickCountWhenRedirect(){

    URLs url = new URLs();

    url.setShortCode("abc123");
    url.setOriginalUrl("https://google.com");
    url.setClickCount(5L);


    when(repository.findByShortCode("abc123"))
            .thenReturn(Optional.of(url));

    service.redirect("abc123");
    assertEquals(6L, url.getClickCount());

    verify(repository).save(url);
}

@Test
void shouldCreateShortUrlSuccessfully() {

       URLs url = new URLs();
       UrlRequest request = new UrlRequest();
       UrlResponse response = new UrlResponse();

         request.setOriginalUrl("https://leetcode.com/u/Kalkidan-Kelemework/");
         response.setShortCode("JHS7Vr");

        url.setShortCode("JHS7Vr");
        url.setOriginalUrl("https://leetcode.com/u/Kalkidan-Kelemework/");

     when(generate.generate()).thenReturn("JHS7Vr");
     when(mapper.toEntity(request)).thenReturn(url);
     when(repository.save(url)).thenReturn(url);
     when(mapper.toResponse(url)).thenReturn(response);

    UrlResponse  result = service.createShortURL(request);

     assertEquals("JHS7Vr", result.getShortCode());
   

     verify(generate).generate();
     verify(repository).save(url);
     verify(mapper).toEntity(request);
     verify(mapper).toResponse(url);



}






}


