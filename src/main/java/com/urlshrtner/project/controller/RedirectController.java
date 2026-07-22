package com.urlshrtner.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.urlshrtner.project.services.UrlService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor()
@RequestMapping("/api/redirect")
public class RedirectController {

     private final UrlService service;

     @GetMapping("/{shortCode}")
     public String redirect(@PathVariable String shortCode) {
     return "redirect:" + service.redirect(shortCode);
     }
    
}
