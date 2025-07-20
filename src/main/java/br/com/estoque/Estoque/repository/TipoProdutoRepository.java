package br.com.estoque.Estoque.repository;

import br.com.estoque.Estoque.model.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {
}
