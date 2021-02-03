package com.mmontsheng.library.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmontsheng.library.entities.Book;

public interface BookRepo extends JpaRepository<Book, String> {

    List<Book> findAllByEnabled(Boolean enabled);

}
