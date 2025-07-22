package br.com.estoque.Estoque.dto;

import java.math.BigDecimal;

public interface LucroProdutoDTO {
    Long getId();
    String getCodigo();
    String getDescricao();
    Integer getQuantidadeSaida();
    BigDecimal getLucroTotal();
}
