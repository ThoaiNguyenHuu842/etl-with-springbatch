package com.thoainguyen.domain;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "nht_warehouse", catalog = "nht_warehouse", name= "fact_transaction_product_monthly")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FactTransactionProductMonthly {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private BigInteger id;
  @Column(name = "product_id")
  private Integer productId;
  @Column(name = "product_name")
  private String productName;
  @Column(name = "total_quantity")
  private Integer totalQuantity;
  @Column(name = "month")
  private Integer month;
  @Column(name = "year")
  private Integer year;
}
