package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u.role FROM tb_users u WHERE u.username LIKE :username")
    User.Role findRoleByUsername(String username);
}
