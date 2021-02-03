package com.mmontsheng.library.rest;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmontsheng.library.dto.BaseResponse;
import com.mmontsheng.library.dto.BookDTO;
import com.mmontsheng.library.entities.Book;
import com.mmontsheng.library.services.BookService;
import com.mmontsheng.library.util.Utility;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    public BookService bookService;

    @GetMapping
    public Callable<ResponseEntity<BaseResponse>> get() {
        BaseResponse response = BaseResponse.builder().data(bookService.get()).build();
        return () -> ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> get(@PathVariable String id) {
        BaseResponse response = BaseResponse.builder().data(bookService.get(id)).build();

        return () -> ResponseEntity.ok(response);
    }

    @PostMapping
    public Callable<ResponseEntity<BaseResponse>> create(@Valid @RequestBody BookDTO request) {
        BaseResponse response = BaseResponse.builder().message("Book created").data(bookService.create(request))
                .build();
        return () -> ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> update(@PathVariable String id, @Valid @RequestBody BookDTO request) {
        BaseResponse response = BaseResponse.builder().message("Book updated").data(bookService.update(id, request))
                .build();
        return () -> ResponseEntity.ok(response);

    }

    @PutMapping("/{id}/toggle-status")
    public Callable<ResponseEntity<BaseResponse>> toggleStatus(@PathVariable String id) {
        Book book = bookService.toggleStatus(id);

        BaseResponse response = BaseResponse.builder()
                .message(Utility.statusUpdatedTo("Book", book.getEnabled())).data(book).build();
        return () -> ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> delete(@PathVariable String id) {
        bookService.delete(id);
        BaseResponse response = BaseResponse.builder().message("Book deleted").build();
        return () -> ResponseEntity.ok(response);
    }
}
