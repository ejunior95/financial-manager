package com.ejunior95.user.financial_manager.transaction;


// Importamos a "mágica" do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta é a interface do Repositório.
 * Ela que vai conversar com o banco de dados.
 */

@Repository // 1. Diz ao Spring que esta é uma camada de Repositório (um "Bean")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    // 2. É SÓ ISSO.
    // ...Sério, não precisa de mais nada por enquanto.

}