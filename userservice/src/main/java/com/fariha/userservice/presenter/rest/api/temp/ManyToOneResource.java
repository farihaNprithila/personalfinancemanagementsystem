package com.fariha.userservice.presenter.rest.api.temp;

import com.fariha.userservice.data.repository.temp.AuthorRepository;
import com.fariha.userservice.data.repository.temp.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManyToOneResource {

    final AuthorRepository authorRepository;
    final BookRepository bookRepository;


    @GetMapping("/author-list")
    public ResponseEntity<List<?>> authorList() {
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @GetMapping("/book-list")
    public ResponseEntity<List<?>> bookList() {
        return ResponseEntity.ok(bookRepository.findAll());
    }
}
