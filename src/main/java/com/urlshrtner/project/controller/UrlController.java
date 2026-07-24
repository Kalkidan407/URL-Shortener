package com.urlshrtner.project.controller;

import java.util.UUID;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlshrtner.project.dto.UpdateUrlRequest;
import com.urlshrtner.project.dto.UrlRequest;
import com.urlshrtner.project.dto.UrlResponse;
import com.urlshrtner.project.model.URLs;
import com.urlshrtner.project.services.UrlService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequiredArgsConstructor() 
@RequestMapping("/api/urls")
public class UrlController {
  
     private final UrlService service;

      @GetMapping("/url/{id}")
      public String getUrlById(@PathVariable UUID id) {
          return "get by id " + service.getShoerCodeById(id);
      }

  

      @PostMapping("/post")
      public UrlResponse createShortUrl(@RequestBody UrlRequest request) {
          return service.createShortURL(request);
      }
      
      @DeleteMapping("/{id}")
     public String deleteById(@PathVariable UUID id) {
      service.deleteById(id);
       return "Deleted successfully";
      }

      @PutMapping("update/{id}")
      public String updateURL(@PathVariable UUID id, @RequestBody UpdateUrlRequest entity) {
          service.updateById(id,entity );
          
          return "updated successfully";
      }
      
     
}
