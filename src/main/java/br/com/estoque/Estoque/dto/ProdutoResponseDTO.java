package br.com.estoque.Estoque.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoResponseDTO {

    private Long id;
    private String codigo;
    private String descricao;

    private String categoria;
    private String fornecedor;

    private BigDecimal valorFornecedor;
    private Integer quantidadeEstoque;

    private Integer totalSaidas;
    private BigDecimal lucroEstimado;

}

