package com.organization.LibraryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.LibraryApp.model.Book;
import com.organization.LibraryApp.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book){
        Book b = getBook(id);
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setAvailable(book.isAvailable());
        b.setCategory(book.getCategory());
        b.setPrice(book.getPrice());
        return bookRepository.save(b);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String query){
        return bookRepository.findByTitleContainingIgnoreCase(query);
    }

}
