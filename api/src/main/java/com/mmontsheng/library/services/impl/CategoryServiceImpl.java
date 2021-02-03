package com.mmontsheng.library.services.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mmontsheng.library.dto.CategoryDTO;
import com.mmontsheng.library.entities.Category;
import com.mmontsheng.library.exceptions.DefaultException;
import com.mmontsheng.library.repos.CategoryRepo;
import com.mmontsheng.library.services.CategoryService;
import com.mmontsheng.library.util.Utility;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;

    @Override
    public List<Category> get() {
        return categoryRepo.findAll();
    }

    @Override
    public Category get(String id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new DefaultException(Utility.doesNotExist("Category")));
    }

    @Override
    public List<Category> get(Boolean enabled) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public Category create(CategoryDTO request) {
        Category category = new Category();
        category.setName(request.getName());
        return save(category);
    }

    @Override
    public Category update(String id, CategoryDTO request) {
        Category category = get(id);
        category.setName(request.getName());

        return save(category);
    }

    @Override
    public void delete(String id) {
        try {
            categoryRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DefaultException(Utility.doesNotExist("Category"));
        }
    }

    @Override
    public Category toggleStatus(String id) {
        throw new NotImplementedException("Not implemented");
    }
    
    @Override
    public Category save(Category category) {
        try {
            return categoryRepo.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new DefaultException(Utility.alreadyExist("Category"));
        }
    }

    @Autowired
    public void setCategoryRepo(CategoryRepo repo) {
        this.categoryRepo = repo;
    }

}
