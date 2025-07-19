package br.com.estoque.Estoque.repository;

import br.com.estoque.Estoque.model.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {

    @Query("SELECT SUM(m.quantidade) FROM MovimentacaoEstoque m WHERE m.produto.id = :produtoId AND m.tipo = 'SAIDA'")
    Integer totalSaidas(Long produtoId);

    @Query("SELECT SUM(m.valorVenda * m.quantidade) - (p.valorFornecedor * SUM(m.quantidade)) FROM MovimentacaoEstoque m JOIN m.produto p WHERE m.produto.id = :produtoId AND m.tipo = 'SAIDA'")
    BigDecimal calcularLucroPorProduto(Long produtoId);
}
