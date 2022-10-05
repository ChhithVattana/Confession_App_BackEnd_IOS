package com.tgi_confession.tgi_confession_db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi_confession.tgi_confession_db.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
  Optional<Account> findByUsername(String username);
}
