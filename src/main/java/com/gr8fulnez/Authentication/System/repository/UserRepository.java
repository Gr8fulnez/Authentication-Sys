package com.gr8fulnez.Authentication.System.repository;

import com.gr8fulnez.Authentication.System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
