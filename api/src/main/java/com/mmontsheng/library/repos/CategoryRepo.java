package com.mmontsheng.library.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmontsheng.library.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, String> {

}
