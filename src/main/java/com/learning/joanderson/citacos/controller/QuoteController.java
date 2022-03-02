package com.learning.joanderson.citacos.controller;

import com.learning.joanderson.citacos.model.QuoteDTO;
import com.learning.joanderson.citacos.service.AlluGoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Configurable
public class QuoteController {

    @Autowired
    private AlluGoService service;

    public ResponseEntity<QuoteDTO> getRandomQuote() {
        QuoteDTO response = service.getRandomQuote();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<QuoteDTO> getQuoteById(int id) {
        QuoteDTO response = service.getQuoteById(id);
        return ResponseEntity.ok(response);
    }
}
