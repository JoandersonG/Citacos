package com.learning.joanderson.citacos.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuoteDTO {
    private Integer id;
    private String frase;
    private String livro;
    private String autor;
}
