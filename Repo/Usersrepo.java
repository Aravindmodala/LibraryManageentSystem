package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Users;

public interface Usersrepo extends JpaRepository<Users, Long>{
	
	//find id by email
	Optional<Users> findByEmail(String email);


}
