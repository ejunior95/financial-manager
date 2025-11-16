package com.ejunior95.user.financial_manager.transaction;

/**
 * Enum para representar os tipos de transação.
 * Em Java, usamos Enums para garantir a segurança dos tipos 
 * (ninguém vai poder salvar "RECEITAA" por engano).
 */
public enum TransactionType {
    INCOME,  // Receita
    EXPENSE  // Despesa
}