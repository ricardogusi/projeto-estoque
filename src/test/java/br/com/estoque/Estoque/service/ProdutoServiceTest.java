package br.com.estoque.Estoque.service;

import br.com.estoque.Estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.repository.ProdutoRepository;
import br.com.estoque.Estoque.service.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoServiceImpl produtoServiceImpl;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    void deveBuscarProdutoExistente() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setDescricao("Notebook");
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        final Produto resultado = produtoServiceImpl.buscar(1L);
        assertNotNull(resultado);
        assertEquals("Notebook", resultado.getDescricao());
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExiste() {
        when(produtoRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RecursoNaoEncontradoException.class, () -> {
            produtoServiceImpl.buscar(99L);
        });
    }

    @Test
    void deveCriarProduto() {
        Produto novo = new Produto();
        novo.setCodigo("ABC123");
        when(produtoRepository.save(novo)).thenReturn(novo);
        final Produto salvo = produtoServiceImpl.criar(novo);
        assertEquals("ABC123", salvo.getCodigo());
    }
}

