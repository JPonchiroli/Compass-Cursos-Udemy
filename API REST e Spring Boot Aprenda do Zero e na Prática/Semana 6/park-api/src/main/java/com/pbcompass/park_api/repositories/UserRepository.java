package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}