package com.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.model.JwtUser;

public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer>{
	
	//custom query
	// fetch the roles of the jwtuser along with the other details
	@Query("select ju from JwtUser ju join fetch ju.roles r where ju.username=?1")
	Optional<JwtUser> findByUsername( String username);

}
