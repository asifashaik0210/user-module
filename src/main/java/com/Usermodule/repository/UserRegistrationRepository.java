package com.Usermodule.repository;

import com.Usermodule.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration,Integer> {
    boolean existsByEmail(String email);
}
