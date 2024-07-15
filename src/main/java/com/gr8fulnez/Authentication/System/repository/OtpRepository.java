package com.gr8fulnez.Authentication.System.repository;

import com.gr8fulnez.Authentication.System.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByEmail(String email);
}
