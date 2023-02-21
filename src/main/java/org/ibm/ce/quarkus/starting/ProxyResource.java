package org.ibm.ce.quarkus.starting;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/proxy")
@ApplicationScoped
public class ProxyResource {

    @Inject
    Logger logger;

    @Inject
    @RestClient
    ProxyRestService pubService;

    @GET
    @Path("/publishers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> getAllPublishersProxy() {
        logger.info("Getting all publishers via proxy");
        return pubService.getAllPublishers();
    }

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooksProxy() {
        logger.info("Getting all books via proxy");
        return pubService.getAllBooks();
    }

    @GET
    @Path("/pubfrombook")
    @Produces(MediaType.APPLICATION_JSON)
    public Publisher getPubFromBook() {
        logger.info("Getting the publisher from a book");
        Book specificBook = pubService.getBook();
        logger.info("Received book with publisher " + specificBook.author);

        return pubService.getPublisher(specificBook.author);
    }

}
