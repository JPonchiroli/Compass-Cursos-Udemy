package com.pbcompass.repositories;

import com.pbcompass.entities.Category;
import com.pbcompass.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
