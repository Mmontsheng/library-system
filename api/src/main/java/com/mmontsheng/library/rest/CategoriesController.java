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
import com.mmontsheng.library.dto.CategoryDTO;
import com.mmontsheng.library.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Authors Controller", description = "To handle all categories related requests")
public class CategoriesController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get All", description = "Get all available categories")
    public Callable<ResponseEntity<BaseResponse>> get() {
        BaseResponse response = BaseResponse.builder().data(categoryService.get()).build();
        return () -> ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get One", description = "Get a specific category by id")
    public Callable<ResponseEntity<BaseResponse>> get(@PathVariable String id) {
        BaseResponse response = BaseResponse.builder().data(categoryService.get(id)).build();

        return () -> ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Create One", description = "Create a new category")
    public Callable<ResponseEntity<BaseResponse>> create(@Valid @RequestBody CategoryDTO request) {
        BaseResponse response = BaseResponse.builder().message("Category created").data(categoryService.create(request))
                .build();
        return () -> ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update One", description = "Updates a specific category by id")
    public Callable<ResponseEntity<BaseResponse>> update(@PathVariable String id,
            @Valid @RequestBody CategoryDTO request) {
        BaseResponse response = BaseResponse.builder().message("Category updated")
                .data(categoryService.update(id, request)).build();
        return () -> ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete One", description = "Deleted an category by id")
    public Callable<ResponseEntity<BaseResponse>> delete(@PathVariable String id) {
        categoryService.delete(id);
        BaseResponse response = BaseResponse.builder().message("Category deleted").build();
        return () -> ResponseEntity.ok(response);
    }
}
