package com.example.homework.purchaseorder.dto;

import com.example.homework.purchaseorder.entity.PurchaseOrder;
import com.example.homework.purchaseorder.entity.PurchaseOrderStatus;
import jakarta.persistence.criteria.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderInfo(
        UUID id,
        UUID productId,
        UUID sellerId,
        UUID memberId,
        BigDecimal amount,
        PurchaseOrderStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static OrderInfo from(PurchaseOrder order){
        return new OrderInfo(
                order.getId(),
                order.getSellerId(),
                order.getMemberId(),
                order.getProductId(),
                order.getAmount(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}
