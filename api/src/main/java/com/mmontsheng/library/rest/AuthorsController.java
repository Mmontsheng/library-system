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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors Controller", description = "To handle all authors related requests")
public class AuthorsController {

    @Autowired
    public AuthorService authorService;

    @GetMapping
    @Operation(summary = "Get All", description = "Get all available authors")
    public Callable<ResponseEntity<BaseResponse>> get() {
        BaseResponse response = BaseResponse.builder().data(authorService.get()).build();
        return () -> ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get One", description = "Get a specific author by id")
    public Callable<ResponseEntity<BaseResponse>> get(@PathVariable String id) {
        BaseResponse response = BaseResponse.builder().data(authorService.get(id)).build();

        return () -> ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Create One", description = "Create a new author")
    public Callable<ResponseEntity<BaseResponse>> create(@Valid @RequestBody AuthorDTO request) {
        BaseResponse response = BaseResponse.builder().message("Author created").data(authorService.create(request))
                .build();
        return () -> ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update One", description = "Updates a specific author by id")
    public Callable<ResponseEntity<BaseResponse>> update(@PathVariable String id,
            @Valid @RequestBody AuthorDTO request) {
        BaseResponse response = BaseResponse.builder().message("Author updated")
                .data(authorService.update(id, request)).build();
        return () -> ResponseEntity.ok(response);

    }

    @PutMapping("/{id}/toggle-status")
    @Operation(summary = "Update Status", description = "Updates a status of a author by id. Basically an enable or disable request")
    public Callable<ResponseEntity<BaseResponse>> toggleStatus(@PathVariable String id) {
        Author author = authorService.toggleStatus(id);
        BaseResponse response = BaseResponse.builder().message(Utility.statusUpdatedTo("Author", author.getEnabled()))
                .data(author).build();
        return () -> ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete One", description = "Deleted an author by id")
    public Callable<ResponseEntity<BaseResponse>> delete(@PathVariable String id) {
        authorService.delete(id);
        BaseResponse response = BaseResponse.builder().message("Author deleted").build();
        return () -> ResponseEntity.ok(response);
    }
}
