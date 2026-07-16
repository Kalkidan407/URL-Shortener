package com.urlshrtner.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UrlResponse {

    private String originalUrl;
    private String shortCode;
    private Long clickCount;
    private java.time.Instant createdAt;
    // private java.time.Instant updatedAt;
    // private java.time.Instant expiresAt;
   
    
}
