package br.com.estoque.Estoque.service.impl;

import br.com.estoque.Estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.repository.ProdutoRepository;
import br.com.estoque.Estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto criar(final Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(final Long id, final Produto novo) {
        final Produto antigo = buscar(id);
        antigo.setDescricao(novo.getDescricao());
        antigo.setTipoProduto(novo.getTipoProduto());
        antigo.setFornecedor(novo.getFornecedor());
        antigo.setValorFornecedor(novo.getValorFornecedor());
        return produtoRepository.save(antigo);
    }

    @Override
    public Produto buscar(final Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));
    }

    @Override
    public void deletar(final Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
}

