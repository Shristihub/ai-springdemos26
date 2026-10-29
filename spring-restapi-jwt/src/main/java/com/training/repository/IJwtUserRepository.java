package com.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.JwtUser;

public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer>{

}
