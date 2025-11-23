package com.example.homework.purchaseorder.repository;

import com.example.homework.purchaseorder.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface OrderRepository extends JpaRepository<PurchaseOrder, UUID> {
}
