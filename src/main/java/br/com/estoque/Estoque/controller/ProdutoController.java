package br.com.estoque.Estoque.controller;

import br.com.estoque.Estoque.dto.ProdutoDTO;
import br.com.estoque.Estoque.exception.RecursoNaoEncontradoException;
import br.com.estoque.Estoque.model.Fornecedor;
import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.model.TipoProduto;
import br.com.estoque.Estoque.repository.FornecedorRepository;
import br.com.estoque.Estoque.repository.TipoProdutoRepository;
import br.com.estoque.Estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable final Long id) {
        return produtoService.buscar(id);
    }

    @PostMapping
    public Produto criar(@RequestBody @Valid final ProdutoDTO dto) {
        Produto produto = montarProdutoAPartirDoDTO(dto);
        return produtoService.criar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable final Long id, @RequestBody @Valid final ProdutoDTO dto) {
        Produto produto = montarProdutoAPartirDoDTO(dto);
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable final Long id) {
        produtoService.deletar(id);
    }

    private Produto montarProdutoAPartirDoDTO(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setCodigo(dto.getCodigo());
        produto.setDescricao(dto.getDescricao());
        produto.setValorFornecedor(dto.getValorFornecedor());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());

        TipoProduto tipoProduto = tipoProdutoRepository.findById(dto.getTipoProdutoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("TipoProduto não encontrado"));
        produto.setTipoProduto(tipoProduto);

        if (dto.getFornecedorId() != null) {
            Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedorId())
                    .orElseThrow(() -> new RecursoNaoEncontradoException("Fornecedor não encontrado"));
            produto.setFornecedor(fornecedor);
        }

        return produto;
    }
}
