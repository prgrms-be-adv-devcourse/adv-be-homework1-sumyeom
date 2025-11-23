package com.example.homework.purchaseorder.presentation.dto;

import com.example.homework.purchaseorder.application.dto.OrderCommand;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderRequest(
//        UUID productId,
//        UUID sellerId,
//        UUID memberId,
        BigDecimal amount
){
    public OrderCommand toCommand(){
        UUID productId = UUID.randomUUID();
        UUID sellerId = UUID.randomUUID();
        UUID memberId = UUID.randomUUID();
        return new OrderCommand(productId, sellerId, memberId, amount);
    }
}
