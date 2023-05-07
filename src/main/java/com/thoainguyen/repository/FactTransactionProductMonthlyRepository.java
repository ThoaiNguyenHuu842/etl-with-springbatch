package com.thoainguyen.repository;

import com.thoainguyen.domain.FactTransactionProductMonthly;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactTransactionProductMonthlyRepository extends
  JpaRepository<FactTransactionProductMonthly, BigInteger> {
  boolean existsByYearAndMonth(int year, int month);
}
