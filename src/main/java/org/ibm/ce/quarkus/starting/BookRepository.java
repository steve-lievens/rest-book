package org.ibm.ce.quarkus.starting;

import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BookRepository {

    @Inject
    Logger logger;

    public List<Book> getAllBooks() {
        logger.info("Returning all books");
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2021, "IT"),
                new Book(2, "Practising Quarkus", "Antonio", 2020, "IT"),
                new Book(3, "Effective Java", "Josh Bloch", 2001, "IT"),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, "IT"));
    }

    public Optional<Book> getBook(int id) {
        logger.info("Returning book with id " + id);
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }

}
