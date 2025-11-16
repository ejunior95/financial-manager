# API de Gerenciador Financeiro (Estudos Java + Spring Boot)
`🎯 Status: Projeto de Estudo`

Este é o meu primeiro projeto de estudos em Java com Spring Boot. O objetivo principal foi aplicar na prática a arquitetura em camadas (Controller, Service, Repository) e os conceitos do Spring Data JPA para criar uma API REST funcional.

A API permite cadastrar, listar e calcular o balanço de transações financeiras (receitas e despesas).

### 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot:** Framework principal para a criação da API REST.
* **Spring Data JPA:** Para comunicação com o banco de dados.
* **Maven:** Gerenciador de dependências.
* **H2 Database:** Banco de dados em memória, utilizado para desenvolvimento.
* **Lombok:** Para reduzir o boilerplate (Getters, Setters, etc.) das classes.

### 📋 Como Executar o Projeto

1. Pré-requisitos:

* Você precisa ter o **JDK 21** (ou superior) instalado.
* Você precisa ter o **Git** instalado.

2. Clonar o Repositório:

```bash
# Clone este repositório
git clone https://github.com/ejunior95/financial-manager.git

# Entre na pasta do projeto
cd financial-manager
```

3. Executar a Aplicação:

* Abra o projeto na sua IDE favorita (VS Code, IntelliJ, etc.).

* Encontre o arquivo principal da aplicação em: 
`src/main/java/com/ejunior95/user/financial_manager/FinancialManagerApplication.java`

* Execute o método `main` (a maioria das IDEs tem um botão **"Run"** ao lado dele).

4. Pronto!

* A API estará rodando em `http://localhost:8080`.

### 🖥️ Acessando o Banco de Dados (H2 Console)

Enquanto a aplicação está rodando, você pode inspecionar o banco de dados em memória diretamente pelo navegador:

1. Acesse: `http://localhost:8080/h2-console`
2. Use as seguintes credenciais (importante!):

* **Driver Class:** `org.h2.Driver`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User Name:** `sa`
* **Password:** (deixe em branco)

### 🏛️ Endpoints da API

**Aqui estão as rotas disponíveis na API:**

| Verbo | Rota | Descrição | Exemplo de Body (JSON) |
| :--- | :--- | :--- | :--- |
| `POST` | `/transactions` | Cria uma nova transação. | `{ "description": "Salário", "amount": 5000, "type": "INCOME" }` |
| `GET` | `/transactions` | Lista todas as transações salvas. | N/A |
| `GET` | `/transactions/balance` | Retorna o balanço total (Receitas - Despesas). | N/A |