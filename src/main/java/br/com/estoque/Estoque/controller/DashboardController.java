package br.com.estoque.Estoque.controller;

import br.com.estoque.Estoque.dto.LucroProdutoDTO;
import br.com.estoque.Estoque.repository.MovimentacaoEstoqueRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public DashboardController(MovimentacaoEstoqueRepository repo) {
        this.movimentacaoEstoqueRepository = repo;
    }

    @GetMapping("/lucro")
    public List<LucroProdutoDTO> getLucroPorProduto() {
        return movimentacaoEstoqueRepository.obterLucroPorProduto();
    }
}

