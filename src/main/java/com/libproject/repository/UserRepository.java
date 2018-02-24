package com.libproject.repository;

import com.libproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artur on 23.02.2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}