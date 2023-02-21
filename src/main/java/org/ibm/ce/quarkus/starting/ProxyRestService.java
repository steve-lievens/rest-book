package org.ibm.ce.quarkus.starting;

import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "proxy-api-svc")
@Path("/api")
public interface ProxyRestService {

    @GET
    @Path("/publishers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publisher> getAllPublishers();

    @GET
    @Path("/books")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks();

    @GET
    @Path("/books/id/2")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook();

    @GET
    @Path("/publishers/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public Publisher getPublisher(@PathParam("author") String author);

}
