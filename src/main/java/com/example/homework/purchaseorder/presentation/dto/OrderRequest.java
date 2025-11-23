package com.example.homework.purchaseorder.presentation.dto;

import com.example.homework.purchaseorder.application.dto.OrderCommand;

import java.math.BigDecimal;

public record OrderRequest(
        BigDecimal amount
){
    public OrderCommand toCommand(){
        return new OrderCommand(amount);
    }
}
