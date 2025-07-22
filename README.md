# Sistema de Estoque - Backend

Este é o backend do sistema de gerenciamento de estoque, desenvolvido com Spring Boot. Ele fornece APIs para gerenciar produtos, movimentações de estoque, fornecedores e relatórios de lucro.

## Funcionalidades

- **Gerenciamento de Produtos**: APIs para criar, atualizar, listar e excluir produtos.
- **Movimentações de Estoque**: APIs para registrar entradas e saídas de produtos.
- **Relatórios**: API para visualizar o lucro total por produto.
- **Configuração Inicial**: Dados iniciais de fornecedores e tipos de produtos.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação.
- **Spring Boot 3.5.3**: Framework para desenvolvimento backend.
- **Spring Data JPA**: Persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Lombok**: Redução de boilerplate no código.
- **JUnit 5**: Framework para testes unitários.
- **Gradle**: Ferramenta de build.

## Estrutura do Projeto

```plaintext
estoque/
├── src/
│   ├── main/
│   │   ├── java/br/com/estoque/Estoque/
│   │   │   ├── controller/       # Controladores REST
│   │   │   ├── dto/              # Objetos de transferência de dados
│   │   │   ├── exception/        # Tratamento de exceções
│   │   │   ├── model/            # Entidades do banco de dados
│   │   │   ├── repository/       # Repositórios JPA
│   │   │   ├── service/          # Interfaces de serviços
│   │   │   ├── service/impl/     # Implementações de serviços
│   │   │   ├── configuration/    # Configurações do sistema
│   │   │   └── EstoqueApplication.java  # Classe principal
│   │   └── resources/
│   │       ├── application.properties  # Configurações do Spring Boot
│   │       └── static/                 # Arquivos estáticos (se necessário)
│   └── test/                           # Testes unitários e de integração
├── build.gradle                        # Configuração do Gradle
├── settings.gradle                     # Configuração do projeto Gradle
├── gradlew                             # Script para executar o Gradle
├── gradlew.bat                         # Script para executar o Gradle no Windows
└── README.md                           # Documentação do projeto
```

## Requisitos

- **Java 17+**
- **Gradle 8.14.3**

## Configuração do Projeto

1. Clone o repositório:

   ```sh
   git clone https://github.com/seu-usuario/estoque-backend.git
   cd estoque
   ```

2. Execute o projeto:

   ```sh
   ./gradlew bootRun
   ```

3. Acesse o console H2 para visualizar o banco de dados em memória:

   - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:estoque`
   - Usuário: `sa`
   - Senha: (vazia)

## Endpoints Principais

### Produtos

- **GET** `/api/produtos`: Lista todos os produtos.
- **GET** `/api/produtos/{id}`: Busca um produto pelo ID.
- **POST** `/api/produtos`: Cria um novo produto.
- **PUT** `/api/produtos/{id}`: Atualiza um produto existente.
- **DELETE** `/api/produtos/{id}`: Exclui um produto.

### Movimentações de Estoque

- **POST** `/api/movimentacoes`: Registra uma movimentação de entrada ou saída.

### Relatórios

- **GET** `/api/dashboard/lucro`: Retorna o lucro total por produto.

## Scripts Disponíveis

- **Executar o projeto**:

  ```sh
  ./gradlew bootRun
  ```

- **Executar os testes**:

  ```sh
  ./gradlew test
  ```

- **Gerar o build**:

  ```sh
  ./gradlew build
  ```

## Dados Iniciais

O sistema inicializa com os seguintes dados:

- **Tipos de Produtos**:
  - Eletrônico
  - Eletrodoméstico
  - Móvel
- **Fornecedores**:
  - Fornecedor A
  - Fornecedor B

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).