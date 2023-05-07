package com.thoainguyen.service;

import com.thoainguyen.domain.FactTransactionProductMonthly;
import com.thoainguyen.repository.FactTransactionProductMonthlyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionProductMonthlyLoader implements ItemWriter<FactTransactionProductMonthly> {

  private final FactTransactionProductMonthlyRepository factTransactionProductMonthlyRepository;

  @Override
  public void write(List<? extends FactTransactionProductMonthly> items) throws Exception {
    log.info("TransactionProductMonthlyLoader::write");
    factTransactionProductMonthlyRepository.saveAll(items);
  }
}
