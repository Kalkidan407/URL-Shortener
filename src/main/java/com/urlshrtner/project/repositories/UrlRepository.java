package com.urlshrtner.project.repositories;

import com.urlshrtner.project.model.URLs;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<URLs, UUID> {
    boolean existsByShortCode(String shortCode);
    Optional<URLs> findByShortCode(String shortCode);


}
