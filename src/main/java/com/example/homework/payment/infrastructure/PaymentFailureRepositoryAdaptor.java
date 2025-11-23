package com.example.homework.payment.infrastructure;

import com.example.homework.payment.domain.PaymentFailure;
import com.example.homework.payment.domain.PaymentFailureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentFailureRepositoryAdaptor implements PaymentFailureRepository {
    private final PaymentFailureJpaRepository failureJpaRepository;
    @Override
    public PaymentFailure save(PaymentFailure failure) {
        return failureJpaRepository.save(failure);
    }
}
