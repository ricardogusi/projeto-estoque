package br.com.estoque.Estoque.repository;

import br.com.estoque.Estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
