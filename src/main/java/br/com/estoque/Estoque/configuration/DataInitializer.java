package br.com.estoque.Estoque.configuration;

import br.com.estoque.Estoque.model.Fornecedor;
import br.com.estoque.Estoque.model.TipoProduto;
import br.com.estoque.Estoque.repository.FornecedorRepository;
import br.com.estoque.Estoque.repository.TipoProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(TipoProdutoRepository tipoProdutoRepo,
                                   FornecedorRepository fornecedorRepo) {
        return args -> {
            if (tipoProdutoRepo.count() == 0) {
                tipoProdutoRepo.save(new TipoProduto(null, "Eletrônico", "Produtos do setor eletrônico"));
                tipoProdutoRepo.save(new TipoProduto(null, "Eletrôdomestico", "Produtos do setor eletrôdomestico"));
                tipoProdutoRepo.save(new TipoProduto(null, "Móvel", "Produtos do setor móvel"));
            }

            if (fornecedorRepo.count() == 0) {
                fornecedorRepo.save(new Fornecedor(null, "Fornecedor A"));
                fornecedorRepo.save(new Fornecedor(null, "Fornecedor B"));
            }
        };
    }
}
