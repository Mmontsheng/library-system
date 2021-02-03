package com.mmontsheng.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mmontsheng.library.dto.BookDTO;
import com.mmontsheng.library.entities.Book;
import com.mmontsheng.library.exceptions.DefaultException;
import com.mmontsheng.library.repos.BookRepo;
import com.mmontsheng.library.services.AuthorService;
import com.mmontsheng.library.services.BookService;
import com.mmontsheng.library.services.CategoryService;
import com.mmontsheng.library.util.Utility;

@Service
public class BookServiceImpl implements BookService {
    private BookRepo bookRepo;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Override
    public List<Book> get() {
        return bookRepo.findAll();
    }

    @Override
    public Book get(String id) {
        return bookRepo.findById(id).orElseThrow(() -> new DefaultException(Utility.doesNotExist("Book")));
    }

    @Override
    public List<Book> get(Boolean enabled) {
        return bookRepo.findAllByEnabled(enabled);
    }

    @Override
    public Book create(BookDTO request) {
        Book book = new Book();
        buildEntity(book, request);
        return save(book);

    }

    @Override
    public Book update(String id, BookDTO request) {
        Book book = get(id);
        buildEntity(book, request);
        return save(book);
    }

    @Override
    public void delete(String id) {
        try {
            bookRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DefaultException(Utility.doesNotExist("Book"));
        }
    }

    @Override
    public Book toggleStatus(String id) {
        Book book = get(id);
        book.setEnabled(!book.getEnabled());

        return bookRepo.save(book);
    }

    @Override
    public Book save(Book book) {
        try {
            return bookRepo.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new DefaultException(Utility.alreadyExist("Book"));
        }
    }

    private void buildEntity(Book book, BookDTO request) {
        book.setTitle(request.getTitle());
        book.setCategory(categoryService.get(request.getCategoryId()));
        book.setAuthor(authorService.get(request.getAuthorId()));
        book.setIsbn(request.getIsbn());
        book.setImage(request.getImage());
        book.setSummary(request.getSummary());
        book.setIsbn(request.getIsbn());
        book.setYear(request.getYear());
    }

    @Autowired
    public void setBookRepo(BookRepo repo) {
        this.bookRepo = repo;
    }

    @Autowired
    public void setCategoryService(CategoryService service) {
        this.categoryService = service;
    }

    @Autowired
    public void setAuthorService(AuthorService service) {
        this.authorService = service;
    }

}
