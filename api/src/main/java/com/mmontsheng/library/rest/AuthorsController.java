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

import com.mmontsheng.library.dto.AuthorDTO;
import com.mmontsheng.library.dto.BaseResponse;
import com.mmontsheng.library.entities.Author;
import com.mmontsheng.library.services.AuthorService;
import com.mmontsheng.library.util.Utility;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    @Autowired
    public AuthorService authorService;

    @GetMapping
    public Callable<ResponseEntity<BaseResponse>> get() {
        BaseResponse response = BaseResponse.builder().data(authorService.get()).build();
        return () -> ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> get(@PathVariable String id) {
        BaseResponse response = BaseResponse.builder().data(authorService.get(id)).build();

        return () -> ResponseEntity.ok(response);
    }

    @PostMapping
    public Callable<ResponseEntity<BaseResponse>> create(@Valid @RequestBody AuthorDTO request) {
        BaseResponse response = BaseResponse.builder().message("Author created").data(authorService.create(request))
                .build();
        return () -> ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> update(@PathVariable String id,
            @Valid @RequestBody AuthorDTO request) {
        BaseResponse response = BaseResponse.builder().message("Author updated")
                .data(authorService.update(id, request)).build();
        return () -> ResponseEntity.ok(response);

    }

    @PutMapping("/{id}/toggle-status")
    public Callable<ResponseEntity<BaseResponse>> toggleStatus(@PathVariable String id) {
        Author author = authorService.toggleStatus(id);
        BaseResponse response = BaseResponse.builder().message(Utility.statusUpdatedTo("Author", author.getEnabled()))
                .data(author).build();
        return () -> ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> delete(@PathVariable String id) {
        authorService.delete(id);
        BaseResponse response = BaseResponse.builder().message("Author deleted").build();
        return () -> ResponseEntity.ok(response);
    }
}
