package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Books;
import com.example.demo.Entity.Transactions;
import com.example.demo.Entity.Users;

@Repository
public interface Transactionrepo extends JpaRepository<Transactions, Long> {
	List<Transactions> findByUser(Users user);
	List<Transactions> findByBook(Books book);
}