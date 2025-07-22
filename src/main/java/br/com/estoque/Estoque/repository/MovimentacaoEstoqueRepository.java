package br.com.estoque.Estoque.repository;

import br.com.estoque.Estoque.dto.LucroProdutoDTO;
import br.com.estoque.Estoque.model.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {

    @Query("""
    SELECT 
        p.id AS id,
        p.codigo AS codigo,
        p.descricao AS descricao,
        SUM(m.quantidade) AS quantidadeSaida,
        SUM((m.valorVenda - p.valorFornecedor) * m.quantidade) AS lucroTotal
    FROM MovimentacaoEstoque m
    JOIN m.produto p
    WHERE m.tipo = 'SAIDA'
    GROUP BY p.id, p.codigo, p.descricao
    """)
    List<LucroProdutoDTO> obterLucroPorProduto();
}
