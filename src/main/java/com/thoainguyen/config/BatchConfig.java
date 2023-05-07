package com.thoainguyen.config;

import com.thoainguyen.domain.FactTransactionProductMonthly;
import com.thoainguyen.domain.Product;
import com.thoainguyen.service.TransactionProductCompletionListener;
import com.thoainguyen.service.TransactionProductMonthlyExtractor;
import com.thoainguyen.service.TransactionProductMonthlyLoader;
import com.thoainguyen.service.TransactionProductMonthlyTransformer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
  @Value("${spring.batch.chunk-size}")
  private Integer chunkSize;

  @Bean("transactionProductMonthlyJob")
  public Job transactionProductMonthlyJob(JobBuilderFactory jobBuilderFactory, Step transactionProductMonthlySteps,
    TransactionProductCompletionListener transactionProductCompletionListener) {
    return jobBuilderFactory
      .get("transactionProductMonthlyJob")
      .incrementer(new RunIdIncrementer())
      .listener(transactionProductCompletionListener)
      .flow(transactionProductMonthlySteps)
      .end()
      .build();
  }


  @Bean("transactionProductMonthlySteps")
  public Step transactionProductMonthlySteps(StepBuilderFactory stepBuilderFactory, TransactionProductMonthlyExtractor reader,
    TransactionProductMonthlyTransformer transformer, TransactionProductMonthlyLoader loader) {
    return stepBuilderFactory
      .get("transactionProductMonthlySteps").<Product, FactTransactionProductMonthly>chunk(chunkSize)
      .reader(reader)
      .processor(transformer)
      .writer(loader)
      .build();
  }
}
