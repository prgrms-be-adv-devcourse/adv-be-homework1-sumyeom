package com.example.homework.purchaseorder.dto;

import java.math.BigDecimal;

public record OrderRequest(
        BigDecimal amount
){}
