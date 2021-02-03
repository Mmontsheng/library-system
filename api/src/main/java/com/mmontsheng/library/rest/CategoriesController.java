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

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    public CategoryService categoryService;

    @GetMapping
    public Callable<ResponseEntity<BaseResponse>> get() {
        BaseResponse response = BaseResponse.builder().data(categoryService.get()).build();
        return () -> ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> get(@PathVariable String id) {
        BaseResponse response = BaseResponse.builder().data(categoryService.get(id)).build();

        return () -> ResponseEntity.ok(response);
    }

    @PostMapping
    public Callable<ResponseEntity<BaseResponse>> create(@Valid @RequestBody CategoryDTO request) {
        BaseResponse response = BaseResponse.builder().message("Category created").data(categoryService.create(request))
                .build();
        return () -> ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> update(@PathVariable String id,
            @Valid @RequestBody CategoryDTO request) {
        BaseResponse response = BaseResponse.builder().message("Category updated")
                .data(categoryService.update(id, request)).build();
        return () -> ResponseEntity.ok(response);

    }

    @DeleteMapping("/{id}")
    public Callable<ResponseEntity<BaseResponse>> delete(@PathVariable String id) {
        categoryService.delete(id);
        BaseResponse response = BaseResponse.builder().message("Category deleted").build();
        return () -> ResponseEntity.ok(response);
    }
}
