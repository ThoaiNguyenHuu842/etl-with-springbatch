package com.thoainguyen.repository;

import com.thoainguyen.domain.Transaction;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, BigInteger> {
  @Query(nativeQuery = true, value = "SELECT COALESCE(SUM(t.quantity),0) " +
                                     "FROM transaction t " +
                                     "WHERE t.product_id = :productId AND YEAR(t.created_date) = :year AND MONTH(t.created_date) = :month")
  Integer getTotalQuantity(@Param("productId") Integer productId, @Param("year") Integer year, @Param("month") Integer month);
}
