package br.com.estoque.Estoque.controller;

import br.com.estoque.Estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.Estoque.model.Fornecedor;
import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.model.TipoProduto;
import br.com.estoque.Estoque.repository.FornecedorRepository;
import br.com.estoque.Estoque.repository.TipoProdutoRepository;
import br.com.estoque.Estoque.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ProdutoController.class)
@AutoConfigureMockMvc
class ProdutoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    @MockBean
    private TipoProdutoRepository tipoProdutoRepository;

    @MockBean
    private FornecedorRepository fornecedorRepository;

    @Test
    void deveRetornarProdutoPorId() throws Exception {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setDescricao("Geladeira");

        when(produtoService.buscar(1L)).thenReturn(produto);

        mockMvc.perform(get("/api/produtos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descricao").value("Geladeira"));
    }

    @Test
    void deveRetornar404QuandoProdutoNaoExiste() throws Exception {
        when(produtoService.buscar(999L)).thenThrow(new RecursoNaoEncontradoException("Não encontrado"));

        mockMvc.perform(get("/api/produtos/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveCriarNovoProduto() throws Exception {
        TipoProduto tipoProdutoMock = new TipoProduto();
        tipoProdutoMock.setId(1L);
        when(tipoProdutoRepository.findById(1L)).thenReturn(Optional.of(tipoProdutoMock));

        Fornecedor fornecedorMock = new Fornecedor();
        fornecedorMock.setId(1L);
        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedorMock));

        Produto novo = new Produto();
        novo.setCodigo("XPT01");
        novo.setDescricao("Mesa");
        novo.setTipoProduto(tipoProdutoMock);
        novo.setFornecedor(fornecedorMock);
        novo.setValorFornecedor(new BigDecimal("200.0"));
        novo.setQuantidadeEstoque(100);

        when(produtoService.criar(any())).thenReturn(novo);

        mockMvc.perform(post("/api/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                            "codigo": "XPT01",
                            "descricao": "Mesa",
                            "tipoProdutoId": 1,
                            "fornecedorId": 1,
                            "valorFornecedor": 200.0,
                            "quantidadeEstoque": 100
                        }
                    """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo").value("XPT01"));
    }
}

