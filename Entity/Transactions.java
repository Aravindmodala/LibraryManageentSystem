package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transactions {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long transaction_id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private Users user; // Relationship to User

	    @ManyToOne
	    @JoinColumn(name = "book_id", nullable = false)
	    private Books book; // Relationship to Book

	    @Enumerated(EnumType.STRING)
	    @Column(name = "transaction_type", nullable = false)
	    private TransactionType transactionType; // Lend or Buy


	    @Column(nullable = false)
	    private LocalDate transactionDate = LocalDate.now(); // Default to current date

	    private LocalDate returnDate; // Optional for borrow transactions

	    private String status; // E.g., "Pending", "Completed", "Overdue"

}
