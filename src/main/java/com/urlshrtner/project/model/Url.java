package com.urlshrtner.project.model;

import jakarta.persistence.*;


@Entity
public class Url{
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;

    @Column(nullable = false, unique = true, length = 10)
    private String shortCode;

    @Column(nullable = false)
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