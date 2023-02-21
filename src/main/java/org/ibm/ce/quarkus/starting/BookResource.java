package org.ibm.ce.quarkus.starting;

import java.util.List;
import java.util.Optional;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/books")
@ApplicationScoped
public class BookResource {

    @Inject
    Logger logger;

    @Inject
    BookRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        logger.info("Returning all books");
        return repository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        int bookCount = getAllBooks().size();
        logger.info("Returning books count : " + bookCount);
        return bookCount;
    }

    @GET
    @Path("/id/{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Returning book with id " + id);
        return repository.getBook(id);
    }

}