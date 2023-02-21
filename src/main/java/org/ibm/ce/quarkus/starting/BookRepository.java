package org.ibm.ce.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookRepository {

    @Inject
    Logger logger;

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2021, genre),
                new Book(2, "Practising Quarkus", "HarperPrism", 2020, genre),
                new Book(3, "Effective Java", "Josh Bloch", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre));
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
