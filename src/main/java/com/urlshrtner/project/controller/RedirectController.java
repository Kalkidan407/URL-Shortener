package com.urlshrtner.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.urlshrtner.project.services.UrlService;


@RestController
public class RedirectController {

     private UrlService service;

     @GetMapping("/{shortCode}")
     public String redirect(@PathVariable String shortCode) {
     return "redirect:" + service.redirect(shortCode);
     }
    
}
