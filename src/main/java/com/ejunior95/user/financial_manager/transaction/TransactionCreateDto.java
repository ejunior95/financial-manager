package com.ejunior95.user.financial_manager.transaction;

import java.math.BigDecimal;

/**
 * DTO (Data Transfer Object) para criar uma nova transação.
 * * Em Java 17+ (que estamos usando), um 'record' é a forma moderna e 
 * concisa de criar uma classe que serve apenas para guardar dados (como um DTO).
 * * Pense nisso como uma 'interface' ou 'type' do TypeScript.
 * Ele automaticamente cria os campos, construtor, getters, etc.
 */
public record TransactionCreateDto(
    String description,
    BigDecimal amount,
    TransactionType type
) {
    // É só isso! Não precisa de @Data do Lombok.
}