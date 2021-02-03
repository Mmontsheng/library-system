package com.mmontsheng.library.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmontsheng.library.entities.Author;

public interface AuthorRepo extends JpaRepository<Author, String> {
    List<Author> findAllByEnabled(Boolean enabled);
}
