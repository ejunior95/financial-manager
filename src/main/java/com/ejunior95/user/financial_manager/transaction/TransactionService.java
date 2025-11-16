package com.ejunior95.user.financial_manager.transaction;

import java.util.List; // Importamos o "Array" do Java (List)
import org.springframework.stereotype.Service;

/**
 * Esta é a camada de Serviço (Lógica de Negócios).
 * É o equivalente ao @Injectable() do Nest.js.
 */
@Service // 1. Diz ao Spring: "Esta classe é um Service, gerencie ela!"
public class TransactionService {

    // 2. Precisamos do Repositório para falar com o banco
    private final TransactionRepository transactionRepository;

    // 3. Injeção de Dependência (Exatamente como no Nest.js!)
    // O Spring vai ver esse construtor e automaticamente vai "injetar"
    // uma instância do TransactionRepository para nós.
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    /**
     * Lógica de Negócios: Criar uma nova transação.
     * Note que recebemos o DTO, e não a Entidade.
     */
    public Transaction createTransaction(TransactionCreateDto dto) {
        
        // Aqui você pode adicionar validações:
        if (dto.amount() == null || dto.amount().signum() <= 0) {
            // Se o valor for nulo, zero ou negativo, poderíamos lançar um erro.
            // (Vamos deixar simples por enquanto)
        }

        // Mapeamento: Convertendo o DTO (dados de entrada) 
        // para a Entidade (o que vai pro banco)
        Transaction newTransaction = new Transaction();
        newTransaction.setDescription(dto.description());
        newTransaction.setAmount(dto.amount());
        newTransaction.setType(dto.type());
        
        // Note: Não definimos ID nem DATA, pois são automáticos!

        // 4. Usamos o repositório para salvar a entidade no banco
        return transactionRepository.save(newTransaction);
    }

    /**
     * Lógica de Negócios: Listar todas as transações.
     */
    public List<Transaction> getAllTransactions() {
        // List<Transaction> é o "Transaction[]" ou "Array<Transaction>" do TS
        return transactionRepository.findAll();
    }
}