package com.urlshrtner.project.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UrlResponse {

    private UUID id;
    private String originalUrl;
    private String shortCode;
    private Long clickCount;
    private java.time.Instant createdAt;
    private String siteName;
    
   
    
}
