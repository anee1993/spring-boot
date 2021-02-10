package com.springfun.springproject.bootstrap;

import com.springfun.springproject.jpa.Author;
import com.springfun.springproject.jpa.Book;
import com.springfun.springproject.jpa.Publisher;
import com.springfun.springproject.repositories.AuthorRepository;
import com.springfun.springproject.repositories.BookRepository;
import com.springfun.springproject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            Author eric  = new Author("Eric", "Evans");
            Book ddd = new Book("Domain Driven Design", "123123");
            eric.getBooks().add(ddd);
            ddd.getAuthors().add(eric);

            authorRepository.save(eric);
            bookRepository.save(ddd);

            Author rod = new Author("Rod", "Johnson");
            Book noEJB = new Book("J2EE Development without EJB", "78901283");

            rod.getBooks().add(noEJB);
            noEJB.getAuthors().add(rod);

            authorRepository.save(rod);
            bookRepository.save(noEJB);

            Publisher publisher = new Publisher();
            publisher.setName("Fractal publications");
            publisher.setCity("New York");
            publisher.setState("FL");
            publisher.setZip("88192");
            publisher.setAddressLine1("Franco Parlo county, 4th Street");

            ddd.setPublisher(publisher);
            publisher.getBooks().add(ddd);

            noEJB.setPublisher(publisher);
            publisher.getBooks().add(noEJB);

            publisherRepository.save(publisher);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of books: " + bookRepository.count());
            System.out.println("Number of Authors: " + authorRepository.count());

            System.out.println("Number of Publishers: " + publisherRepository.count());

            System.out.println("Number of books from the given publisher: " + publisher.getBooks().size());

    }
}
