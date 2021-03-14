/**
 * 
 */
package com.dev.eficiente.casadocodigo.resources;

import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.dev.eficiente.casadocodigo.form.request.LivroRequestForm;
import com.dev.eficiente.casadocodigo.model.Livro;
import javax.ws.rs.core.UriBuilder;

/**
 * @author Valdir Junior
 *
 */
@RequestScoped
@Path("/livros")
public class LivroRequestFormEndpoint {

  @PersistenceContext
  private EntityManager manager;

  /**
   * @param livrorequestform
   * @return
   */
  @POST
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(@Valid final LivroRequestForm livro) {
    // TODO: process the given livrorequestform
    // you may want to use the following return statement, assuming that LivroRequestForm#getId() or
    // a similar method
    // would provide the identifier to retrieve the created LivroRequestForm resource:
    // return
    // Response.created(UriBuilder.fromResource(LivroRequestFormEndpoint.class).path(String.valueOf(livrorequestform.getId())).build()).build();
    Livro entity = livro.map(manager);
    manager.persist(entity);

    URI uri = UriBuilder.fromResource(LivroRequestFormEndpoint.class)
        .path(String.valueOf(entity.getId())).build();

    return Response.created(uri).entity(livro).build();
  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Long id) {
    // TODO: retrieve the livrorequestform
    LivroRequestForm livrorequestform = null;
    if (livrorequestform == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(livrorequestform).build();
  }

  /**
   * @param startPosition
   * @param maxResult
   * @return
   */
  @GET
  public List<LivroRequestForm> listAll(@QueryParam("start") final Integer startPosition,
      @QueryParam("max") final Integer maxResult) {
    // TODO: retrieve the livrorequestforms
    final List<LivroRequestForm> livrorequestforms = null;
    return livrorequestforms;
  }

}
