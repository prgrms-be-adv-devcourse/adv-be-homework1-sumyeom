package com.example.homework.purchaseorder.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Page<PurchaseOrder> findAll(Pageable pageable);

    Optional<PurchaseOrder> findById(UUID id);

    PurchaseOrder save(PurchaseOrder member);

    void deleteById(UUID id);
}
