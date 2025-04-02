package com.authservice.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import com.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
