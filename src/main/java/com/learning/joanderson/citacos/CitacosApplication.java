package com.learning.joanderson.citacos;

import com.learning.joanderson.citacos.controller.QuoteController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@ComponentScan
public class CitacosApplication {

	@Bean
	public QuoteController getController() {
		return new QuoteController();
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder
				.baseUrl("https://allugofrases.herokuapp.com/frases")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CitacosApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(CitacosApplication.class);

	@Bean
	public CommandLineRunner run() {
		return args -> {
			log.info(getController().getRandomQuote().toString());
			log.info(getController().getQuoteById(2).toString());
		};
	}

}
