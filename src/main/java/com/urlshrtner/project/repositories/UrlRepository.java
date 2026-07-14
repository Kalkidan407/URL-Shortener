package com.urlshrtner.project.repositories;

import com.urlshrtner.project.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {}
