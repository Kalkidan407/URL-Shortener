package com.urlshrtner.project.model;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(nullable = false)
    private String siteName;

    @Column(nullable = false, unique = true, length = 10)
    private String shortCode;

    @Column()
    private Long clickCount;

    @CreationTimestamp
    @Column(nullable = false, updatable =  false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    @Column
    private java.time.Instant expiresAt;

    @Column(nullable = false)
    private Boolean deleted;
}