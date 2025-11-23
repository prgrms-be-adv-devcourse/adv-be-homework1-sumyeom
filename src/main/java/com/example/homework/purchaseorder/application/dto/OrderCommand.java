package com.example.homework.purchaseorder.application.dto;

import java.math.BigDecimal;

public record OrderCommand(
        BigDecimal amount
) {

}
