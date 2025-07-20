package br.com.estoque.Estoque.dto;

import br.com.estoque.Estoque.model.Produto;
import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String codigo,
        String descricao,
        String tipoProdutoDescricao,
        String fornecedorNome,
        BigDecimal valorFornecedor,
        Integer quantidadeEstoque
) {
    public ProdutoResponseDTO(Produto p) {
        this(
                p.getId(),
                p.getCodigo(),
                p.getDescricao(),
                p.getTipoProduto() != null ? p.getTipoProduto().getDescricao() : null,
                p.getFornecedor() != null ? p.getFornecedor().getNome() : null,
                p.getValorFornecedor(),
                p.getQuantidadeEstoque()
        );
    }
}
