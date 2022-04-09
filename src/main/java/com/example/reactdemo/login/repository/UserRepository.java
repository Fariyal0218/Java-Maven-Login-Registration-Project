package com.example.reactdemo.login.repository;

import com.example.reactdemo.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserNameAndPassword(String email,String password);
}
