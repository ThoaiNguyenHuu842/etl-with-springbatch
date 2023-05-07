package com.thoainguyen.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EtlEndpoint {
  private final JobLauncher jobLauncher;
  @Qualifier("transactionProductMonthlyJob")
  private final Job transactionProductMonthlyJob;

  @PostMapping("/etl")
  public void triggerEtl(@RequestParam int year, @RequestParam int month)
    throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    log.info("----------RUNNING ETL----------");
    jobLauncher.run(transactionProductMonthlyJob, new JobParametersBuilder()
      .addLong("timestamp", System.currentTimeMillis())
      .addString("year", String.valueOf(year))
      .addString("month", String.valueOf(month))
      .toJobParameters());
  }
}
