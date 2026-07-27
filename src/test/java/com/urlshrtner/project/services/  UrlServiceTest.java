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

        when(repository.findByShortCode("JHS7Vr"))
            .thenReturn(Optional.of(url));


     String result = service.redirect("JHS7Vr");
    
    assertEquals(1L, url.getClickCount());

    assertEquals("https://leetcode.com/u/Kalkidan-Kelemework/", result);

    verify(repository).save(url);

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

  

}