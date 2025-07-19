package br.com.estoque.Estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue
    private Long id;

    private String codigo;
    private String descricao;

    @ManyToOne
    private TipoProduto tipoProduto;

    @ManyToOne
    private Fornecedor fornecedor;

    private BigDecimal valorFornecedor;
    private int quantidadeEstoque;
}

