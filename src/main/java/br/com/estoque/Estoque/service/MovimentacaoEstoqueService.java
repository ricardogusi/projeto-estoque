package br.com.estoque.Estoque.service;

import br.com.estoque.Estoque.model.MovimentacaoEstoque;

public interface MovimentacaoEstoqueService {

    MovimentacaoEstoque movimentar(final MovimentacaoEstoque mov);
}
