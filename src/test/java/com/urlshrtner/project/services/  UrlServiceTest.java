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

}