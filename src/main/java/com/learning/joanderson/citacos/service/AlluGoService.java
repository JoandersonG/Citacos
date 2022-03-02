package com.learning.joanderson.citacos.service;

import com.learning.joanderson.citacos.model.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AlluGoService {

    private static final String URI = "https://allugofrases.herokuapp.com/frases/";

    @Autowired
    private WebClient webClient;

    public QuoteDTO getRandomQuote() {
        Mono<QuoteDTO> monoQuote = this.webClient
                .method(HttpMethod.GET)
                .uri("/random")
                .retrieve()
                .bodyToMono(QuoteDTO.class);

        return monoQuote.block();
    }

    public QuoteDTO getQuoteById(int id) {

        Mono<QuoteDTO> monoQuote = this.webClient
                .method(HttpMethod.GET)
                .uri("/find/{id}", id)
                .retrieve()
                .bodyToMono(QuoteDTO.class);

        return monoQuote.block();
    }



}
