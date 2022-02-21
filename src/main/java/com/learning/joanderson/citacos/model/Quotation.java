package com.learning.joanderson.citacos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quotation {
    private int id;
    private String frase;
    private String livro;
    private String autor;

    @Override
    public String toString() {
        return frase;
    }
}
