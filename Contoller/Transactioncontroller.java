package com.example.demo.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Books;
import com.example.demo.Entity.Transactions;
import com.example.demo.Entity.Users;
import com.example.demo.Service.Transactionservice;

@RestController
@RequestMapping("/transactions")
public class Transactioncontroller {
	@Autowired
    private Transactionservice transactionService;

    // Create a new transaction (borrow, return, or buy)
    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
        Transactions savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok(savedTransaction);
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        List<Transactions> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Get a transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable Long id) {
        Transactions transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    // Get transactions by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transactions>> getTransactionsByUser(@PathVariable Long userId) {
        Users user = new Users(); // Replace this with actual logic to retrieve the user (e.g., from the database)
        user.setUser_id(userId);
        List<Transactions> transactions = transactionService.getTransactionsByUser(user);
        return ResponseEntity.ok(transactions);
    }

    // Get transactions by book
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Transactions>> getTransactionsByBook(@PathVariable Long bookId) {
        Books book = new Books(); // Replace this with actual logic to retrieve the book (e.g., from the database)
        book.setBook_id(bookId);
        List<Transactions> transactions = transactionService.getTransactionsByBook(book);
        return ResponseEntity.ok(transactions);
    }
}


