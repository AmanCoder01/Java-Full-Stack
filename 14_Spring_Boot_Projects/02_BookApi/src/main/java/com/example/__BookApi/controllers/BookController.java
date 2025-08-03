package com.example.__BookApi.controllers;

import com.example.__BookApi.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private Map<Long, Book> bookDb = new HashMap<>();


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(new ArrayList<>(bookDb.values()));
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        bookDb.put(book.getId(),book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId){
        Book book = bookDb.get(bookId);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(book);
    }


    @PutMapping("/{bookId}")
    public ResponseEntity<Void> updateBookById(@PathVariable Long bookId,
                                            @RequestBody Book book){
        Book bookFromDb = bookDb.get(bookId);
        if(bookFromDb == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        bookDb.put(bookId,book);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PatchMapping("/{bookId}")
    public ResponseEntity<Book> updatePatchBookById(@PathVariable Long bookId,
                                            @RequestBody Double newPrice){
        Book bookFromDb = bookDb.get(bookId);
        if(bookFromDb == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        bookFromDb.setPrice(newPrice);
        bookDb.put(bookId,bookFromDb);

        return ResponseEntity.ok(bookFromDb);
    }

}
