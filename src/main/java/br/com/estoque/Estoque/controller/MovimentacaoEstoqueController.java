package br.com.estoque.Estoque.controller;

import br.com.estoque.Estoque.model.MovimentacaoEstoque;
import br.com.estoque.Estoque.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @PostMapping
    public MovimentacaoEstoque movimentar(@RequestBody final MovimentacaoEstoque mov) {
        return movimentacaoEstoqueService.movimentar(mov);
    }
}

