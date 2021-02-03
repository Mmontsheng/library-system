package com.mmontsheng.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mmontsheng.library.dto.AuthorDTO;
import com.mmontsheng.library.entities.Author;
import com.mmontsheng.library.exceptions.DefaultException;
import com.mmontsheng.library.repos.AuthorRepo;
import com.mmontsheng.library.services.AuthorService;
import com.mmontsheng.library.util.Utility;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepo authorRepo;

    @Override
    public List<Author> get() {
        return authorRepo.findAll();
    }

    @Override
    public Author get(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new DefaultException(Utility.doesNotExist("Author")));
    }

    @Override
    public List<Author> get(Boolean enabled) {
        return authorRepo.findAllByEnabled(enabled);
    }

    @Override
    public Author create(AuthorDTO request) {
        Author author = new Author();
        buildEntity(request, author);
        return save(author);
    }

    @Override
    public Author update(String id, AuthorDTO request) {
        Author author = get(id);
        buildEntity(request, author);

        return save(author);
    }

    @Override
    public void delete(String id) {
        try {
            authorRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new DefaultException(Utility.doesNotExist("Author"));
        }
    }

    @Override
    public Author toggleStatus(String id) {
        Author author = get(id);
        author.setEnabled(!author.getEnabled());

        return authorRepo.save(author);
    }

    @Override
    public Author save(Author author) {
        try {
            return authorRepo.save(author);
        } catch (DataIntegrityViolationException e) {
            throw new DefaultException(Utility.alreadyExist("Author"));
        }
    }

    private void buildEntity(AuthorDTO request, Author author) {
        author.setName(request.getName());
        author.setSurname(request.getSurname());
    }

    @Autowired
    public void setAuthorRepo(AuthorRepo repo) {
        this.authorRepo = repo;
    }

}
