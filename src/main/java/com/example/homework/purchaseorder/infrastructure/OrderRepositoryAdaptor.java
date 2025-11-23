package com.example.homework.purchaseorder.infrastructure;

import com.example.homework.purchaseorder.domain.OrderRepository;
import com.example.homework.purchaseorder.domain.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdaptor implements OrderRepository {

    private final OrderJpaRepository jpaRepository;
    @Override
    public Page<PurchaseOrder> findAll(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public Optional<PurchaseOrder> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public PurchaseOrder save(PurchaseOrder order) {
        return jpaRepository.save(order);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }
}
