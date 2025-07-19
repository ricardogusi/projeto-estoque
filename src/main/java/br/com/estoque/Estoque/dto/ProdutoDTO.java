package br.com.estoque.Estoque.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoDTO {

    private Long id;

    @NotBlank
    private String codigo;

    @NotBlank
    private String descricao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long fornecedorId;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal valorFornecedor;

    private Integer quantidadeEstoque;

}

