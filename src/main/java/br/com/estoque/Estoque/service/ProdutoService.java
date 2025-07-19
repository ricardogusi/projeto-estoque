package br.com.estoque.Estoque.service;

import br.com.estoque.Estoque.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto criar(final Produto produto);

    Produto atualizar(final Long id, final Produto novo);

    Produto buscar(final Long id);

    void deletar(final Long id);

    List<Produto> listar();
}
