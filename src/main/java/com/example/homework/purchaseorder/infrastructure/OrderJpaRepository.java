package com.example.homework.purchaseorder.infrastructure;

import com.example.homework.purchaseorder.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface OrderJpaRepository extends JpaRepository<PurchaseOrder, UUID> {
}
