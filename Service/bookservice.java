package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Books;
import com.example.demo.Repo.Bookrepo;

@Service
public class bookservice {
	@Autowired
    private Bookrepo bookRepo;

    // Add a new book
    public Books addBook(Books book) {
        return bookRepo.save(book);
    }

    // Get all books
    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    // Get a book by ID
    public Optional<Books> getBookById(Long id) {
        return bookRepo.findById(id);
    }

    // Update book details
    public Books updateBook(Long id, Books updatedBook) {
        Optional<Books> existingBook = bookRepo.findById(id);
        if (existingBook.isPresent()) {
            Books book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setDescription(updatedBook.getDescription());
            book.setGenre(updatedBook.getGenre());
            book.setIsbn(updatedBook.getIsbn());
            book.setPrice(updatedBook.getPrice());
            book.setAvailable_copies(updatedBook.getAvailable_copies());
            return bookRepo.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    // Delete a book
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}


