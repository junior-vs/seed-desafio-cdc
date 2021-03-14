/**
 * 
 */
package com.dev.eficiente.casadocodigo.resources;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import com.dev.eficiente.casadocodigo.form.request.EstadoRequestForm;
import com.dev.eficiente.casadocodigo.model.Estado;

/**
 * @author Valdir Junior
 *
 */
@RequestScoped
@Path("/estados")
public class EstadoEndpoint {

  @PersistenceContext
  EntityManager manager;

  /**
   * @param estadorequestform
   * @return
   */
  @POST
  @Transactional
  public Response create(@Valid final EstadoRequestForm estadorequestform) {

    Estado estado = estadorequestform.map(manager);
    manager.persist(estado);

    return Response.created(
        UriBuilder.fromResource(EstadoEndpoint.class).path(String.valueOf(estado.getId())).build())
        .build();
  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Long id) {
    // TODO: retrieve the estadorequestform
    EstadoRequestForm estadorequestform = null;
    if (estadorequestform == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(estadorequestform).build();
  }

  /**
   * @param startPosition
   * @param maxResult
   * @return
   */
  @GET
  public List<EstadoRequestForm> listAll(@QueryParam("start") final Integer startPosition,
      @QueryParam("max") final Integer maxResult) {
    // TODO: retrieve the estadorequestforms
    final List<EstadoRequestForm> estadorequestforms = null;
    return estadorequestforms;
  }

}
