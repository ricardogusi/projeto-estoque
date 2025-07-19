package br.com.estoque.Estoque.service.impl;

import br.com.estoque.Estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.Estoque.exception.SaldoInsuficienteException;
import br.com.estoque.Estoque.model.MovimentacaoEstoque;
import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.model.TipoMovimentacao;
import br.com.estoque.Estoque.repository.MovimentacaoEstoqueRepository;
import br.com.estoque.Estoque.repository.ProdutoRepository;
import br.com.estoque.Estoque.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoEstoqueServiceImpl implements MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public MovimentacaoEstoque movimentar(final MovimentacaoEstoque movimentacaoEstoque) {
        final Produto produto = produtoRepository.findById(movimentacaoEstoque.getProduto().getId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        if (movimentacaoEstoque.getTipo() == TipoMovimentacao.SAIDA && produto.getQuantidadeEstoque() < movimentacaoEstoque.getQuantidade()) {
            throw new SaldoInsuficienteException("Quantidade em estoque insuficiente.");
        }

        if (movimentacaoEstoque.getTipo() == TipoMovimentacao.SAIDA) {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - movimentacaoEstoque.getQuantidade());
        } else {
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + movimentacaoEstoque.getQuantidade());
        }

        produtoRepository.save(produto);
        movimentacaoEstoque.setDataVenda(LocalDateTime.now());
        return movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }
}

