package com.thoainguyen.service;

import com.thoainguyen.domain.Product;
import com.thoainguyen.repository.ProductRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionProductMonthlyExtractor extends RepositoryItemReader<Product> {

  public TransactionProductMonthlyExtractor(@Autowired ProductRepository productRepository) {
    this.setRepository(productRepository);
    this.setMethodName("findAll");
    Map<String, Direction> sorts = new HashMap<>();
    sorts.put("id", Direction.ASC);
    this.setSort(sorts);
  }

  @Override
  protected Product doRead() throws Exception {
    log.info("TransactionProductMonthlyExtractor::doRead");
    return super.doRead();
  }
}
