package com.organization.LibraryApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.LibraryApp.dto.BookDto;
import com.organization.LibraryApp.model.Book;
import com.organization.LibraryApp.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> add(@RequestBody Book book){
        return ResponseEntity.ok(BookDto.fromEntity(bookService.addBook(book)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(BookDto.fromEntity(bookService.getBook(id)));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll(){
        return ResponseEntity.ok(bookService.getAllBooks().stream().map(BookDto::fromEntity).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(BookDto.fromEntity(bookService.updateBook(id, book)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> search(@RequestParam("title") String title) {
        return ResponseEntity.ok(bookService.searchBooks(title).stream().map(BookDto::fromEntity).toList());
    }

}
