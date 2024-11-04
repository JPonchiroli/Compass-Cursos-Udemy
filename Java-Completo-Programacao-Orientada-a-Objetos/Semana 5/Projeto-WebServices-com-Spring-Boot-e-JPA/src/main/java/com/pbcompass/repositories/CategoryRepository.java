package com.pbcompass.repositories;

import com.pbcompass.entities.Category;
import com.pbcompass.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
