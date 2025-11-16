package com.ejunior95.user.financial_manager.transaction;

import java.math.BigDecimal;
import java.util.List; // O "Array" do Java

// import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta é a camada de Controller (a porta de entrada HTTP).
 * É o equivalente ao @Controller() do Nest.js.
 */
@RestController // 1. Combina @Controller + @ResponseBody (já retorna JSON)
@RequestMapping("/transactions") // 2. Prefixo da rota (todas as rotas aqui começam com /transactions)
public class TransactionController {
    
    // 3. Precisamos do Service (o cérebro)
    private final TransactionService transactionService;

    // 4. Injeção de Dependência (igual ao Service)
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    /**
     * Endpoint para CRIAR uma nova transação.
     * Rota: POST /transactions
     */
    @PostMapping // 5. Mapeia este método para o verbo HTTP POST
    @ResponseStatus(HttpStatus.CREATED) // 6. Define o código de status HTTP para 201 (Created)
    public Transaction createTransaction(@RequestBody TransactionCreateDto dto) {
        // 7. @RequestBody: Pega o JSON do corpo da requisição e 
        //    converte para o nosso DTO (TransactionCreateDto).
        //    (Equivalente ao @Body() do Nest)
        
        return this.transactionService.createTransaction(dto);
    }


    /**
     * Endpoint para LISTAR todas as transações.
     * Rota: GET /transactions
     */
    @GetMapping // 8. Mapeia este método para o verbo HTTP GET
    public List<Transaction> getAllTransactions() {
        return this.transactionService.getAllTransactions();
    }

    /**
     * Endpoint para buscar o balanço geral (Receitas - Despesas).
     * Rota: GET /transactions/balance
     */
    @GetMapping("/balance")
    public BigDecimal getBalance() {
        // O Controller só repassa a chamada. A lógica está no Service.
        return this.transactionService.getBalance();
    }
}