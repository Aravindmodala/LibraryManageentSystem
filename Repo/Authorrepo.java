package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Authors;

@Repository
public class Authorrepo {
	public interface AuthorRepository extends JpaRepository<Authors, Long> {
	    
	}
}
