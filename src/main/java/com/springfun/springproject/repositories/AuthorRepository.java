package com.springfun.springproject.repositories;

import com.springfun.springproject.jpa.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
