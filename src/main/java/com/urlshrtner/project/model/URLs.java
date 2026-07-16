package com.urlshrtner.project.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Setter
@Getter
public class URLs{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true, length = 10)
    private String shortCode;

    @Column
    private Long clickCount;

    @Column(nullable = false)
    private java.time.Instant createdAt;

    @Column(nullable = false)
    private java.time.Instant updatedAt;

    @Column
    private java.time.Instant expiresAt;

    @Column(nullable = false)
    private Boolean deleted;
}