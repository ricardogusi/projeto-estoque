package br.com.estoque.Estoque.controller;

import br.com.estoque.Estoque.model.Produto;
import br.com.estoque.Estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable final Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public Produto criar(@RequestBody @Valid final Produto produto) {
        return service.criar(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable final Long id, @RequestBody final Produto produto) {
        return service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable final Long id) {
        service.deletar(id);
    }
}

