package com.kevinpe.auth_service.repository;

import com.kevinpe.auth_service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
