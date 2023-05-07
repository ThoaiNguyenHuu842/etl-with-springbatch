package com.thoainguyen.dto;

import lombok.Data;

@Data
public class FactTransactionProductMonthlyDto {
  private Integer productId;
  private String productName;
  private Integer totalQuantity;
  private Integer month;
  private Integer year;
}
