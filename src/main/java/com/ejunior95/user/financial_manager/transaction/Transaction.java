package com.ejunior95.user.financial_manager.transaction;

// Importamos as ferramentas que vamos usar
import java.math.BigDecimal; // Para dinheiro
import java.time.LocalDate;  // Para datas

import org.hibernate.annotations.CreationTimestamp; // Para datas automáticas

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // A mágica do Lombok!

/**
 * Esta é a nossa classe Model (o que é uma Transação)
 * e também a nossa Entidade (como ela será salva no banco).
 */

@Entity // 1. Diz ao Spring que esta classe é uma tabela no banco de dados
@Data   // 2. Mágica do Lombok: cria Getters, Setters, construtores, etc.
public class Transaction {

    @Id // 3. Marca este campo como a Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 4. Diz ao banco para auto-incrementar este ID
    private long id;

    private String description;

    // 5. Usamos BigDecimal para dinheiro. É o tipo correto em Java 
    //    para evitar erros de arredondamento (nunca use double/float!).
    private BigDecimal amount;

    @Enumerated(EnumType.STRING) // 6. Diz ao Spring para salvar o NOME do enum ("INCOME") 
                                 //    no banco, e não o número (0 ou 1).
    private TransactionType type;

    @CreationTimestamp // 7. Mágica do Spring: define automaticamente a data de criação
    private LocalDate date;
}