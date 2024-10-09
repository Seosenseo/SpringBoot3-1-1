package com.example.springtask311.repository;

import com.example.springtask311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
