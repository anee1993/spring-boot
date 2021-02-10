package com.springfun.springproject.repositories;

import com.springfun.springproject.jpa.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
