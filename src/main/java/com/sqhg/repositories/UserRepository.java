package com.sqhg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sqhg.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
