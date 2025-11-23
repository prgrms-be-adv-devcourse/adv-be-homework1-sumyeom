package com.example.homework.purchaseorder.application;

import com.example.homework.common.ResponseEntity;
import com.example.homework.purchaseorder.application.dto.OrderCommand;
import com.example.homework.purchaseorder.application.dto.OrderInfo;
import com.example.homework.purchaseorder.domain.OrderRepository;
import com.example.homework.purchaseorder.presentation.dto.OrderRequest;
import com.example.homework.purchaseorder.domain.PurchaseOrder;
import com.example.homework.purchaseorder.domain.PurchaseOrderStatus;
import com.example.homework.purchaseorder.infrastructure.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public ResponseEntity<OrderInfo> create(OrderCommand command) {
        PurchaseOrder order = PurchaseOrder.create(command.amount());
        order.setSellerId(UUID.randomUUID());
        order.setMemberId(UUID.randomUUID());
        order.setProductId(UUID.randomUUID());
        PurchaseOrder saved = orderRepository.save(order);
        OrderInfo response = OrderInfo.from(saved);
        return new ResponseEntity<>(HttpStatus.CREATED.value(),response,1);

    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<OrderInfo>> findAll(Pageable pageable) {
        Page<PurchaseOrder> page = orderRepository.findAll(pageable);
        List<OrderInfo> orders = page.stream()
                .map(OrderInfo::from)
                .toList();
        return new ResponseEntity<>(HttpStatus.OK.value(),orders,page.getTotalElements());
    }

    @Transactional
    public ResponseEntity<OrderInfo> statusChange(String id, PurchaseOrderStatus status) {
        PurchaseOrder order = orderRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new IllegalArgumentException("order not found"));

        order.statusChange(status);
        OrderInfo response = OrderInfo.from(order);
        return new ResponseEntity<>(HttpStatus.CREATED.value(), response,1);
    }
}
