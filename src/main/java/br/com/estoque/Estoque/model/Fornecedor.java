package br.com.estoque.Estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
}

