package com.learning.joanderson.citacos;

import com.learning.joanderson.citacos.model.Quotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CitacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitacosApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(CitacosApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Quotation quotation = restTemplate.getForObject(
					"https://allugofrases.herokuapp.com/frases/random",
					Quotation.class
			);
			assert quotation != null;
			log.info(quotation.toString());
		};
	}

}
