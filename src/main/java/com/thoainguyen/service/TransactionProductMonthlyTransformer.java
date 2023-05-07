package com.thoainguyen.service;

import com.thoainguyen.domain.FactTransactionProductMonthly;
import com.thoainguyen.domain.Product;
import com.thoainguyen.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
@RequiredArgsConstructor
@Slf4j
public class TransactionProductMonthlyTransformer implements ItemProcessor<Product, FactTransactionProductMonthly> {

  @Value("#{jobParameters['year']}")
  private int year;

  @Value("#{jobParameters['month']}")
  private int month;

  private final TransactionRepository transactionRepository;

  @Override
  public FactTransactionProductMonthly process(Product product) {
    log.info("TransactionProductMonthlyTransformer::process");
    return FactTransactionProductMonthly.builder()
      .productId(product.getId())
      .productName(product.getName())
      .month(month)
      .year(year)
      .totalQuantity(transactionRepository.getTotalQuantity(product.getId(), year, month))
      .build();
  }
}
