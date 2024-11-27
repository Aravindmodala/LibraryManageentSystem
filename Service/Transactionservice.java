package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Books;
import com.example.demo.Entity.Transactions;
import com.example.demo.Entity.Users;
import com.example.demo.Repo.Transactionrepo;

@Service
public class Transactionservice {
	@Autowired
    private Transactionrepo transactionRepository;

    // Save a transaction (borrow, return, or buy)
    public Transactions saveTransaction(Transactions transaction) {
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get a transaction by ID
    public Transactions getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with ID: " + id));
    }

    // Get transactions by user
    public List<Transactions> getTransactionsByUser(Users user) {
        return transactionRepository.findByUser(user);
    }

    // Get transactions by book
    public List<Transactions> getTransactionsByBook(Books book) {
        return transactionRepository.findByBook(book);
    }
}


