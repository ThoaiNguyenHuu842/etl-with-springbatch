package com.thoainguyen.repository;

import com.thoainguyen.domain.Product;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, BigInteger> {

}
