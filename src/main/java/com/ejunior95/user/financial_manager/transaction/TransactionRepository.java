package com.ejunior95.user.financial_manager.transaction;

import java.math.BigDecimal; // Importe o BigDecimal
import com.ejunior95.user.financial_manager.transaction.Transaction;

// Importamos a "mágica" do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Importe o @Query
import org.springframework.data.repository.query.Param; // Importe o @Param
import org.springframework.stereotype.Repository;

/**
 * Esta é a interface do Repositório.
 * Ela que vai conversar com o banco de dados.
 */

@Repository // 1. Diz ao Spring que esta é uma camada de Repositório (um "Bean")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    /**
     * Novo método para somar os valores por tipo.
     * * 1. @Query: Permite escrever uma query customizada.
     * 2. JPQL: Isso não é SQL puro, é JPQL (Java Persistence Query Language).
     * - 'Transaction' é o NOME DA CLASSE (Entidade), não da tabela.
     * - 't.type' e 't.amount' são os NOMES DOS CAMPOS, não das colunas.
     * 3. :type : É um "parâmetro nomeado".
     * 4. COALESCE(..., 0.0): É uma função SQL/JPQL. Se o SUM() retornar NULL
     * (porque não há transações daquele tipo), ele retorna 0.0. Isso
     * evita o NullPointerException no Java.
     */
    @Query("SELECT COALESCE(SUM(t.amount), 0.0) FROM Transaction t WHERE t.type = :type")
    BigDecimal sumAmountByType(@Param("type") TransactionType type);

}