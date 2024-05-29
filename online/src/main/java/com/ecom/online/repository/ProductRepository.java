package com.ecom.online.repository;

import com.ecom.online.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByIsProductavailable(boolean isProductAvailable);

}
