package br.com.estoque.Estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Produto produto;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    private BigDecimal valorVenda;
    private LocalDateTime dataVenda;
    private int quantidade;
}

