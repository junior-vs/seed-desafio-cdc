/**
 * 
 */
package com.dev.eficiente.casadocodigo.resources;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
import com.dev.eficiente.casadocodigo.domain.EstadoVO;
import com.dev.eficiente.casadocodigo.form.EstadoRequestForm;
import com.dev.eficiente.casadocodigo.model.Estado;

/**
 * @author Valdir Junior
 *
 */
@RequestScoped
@Path("/estados")
public class EstadoResource {

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
        UriBuilder.fromResource(EstadoResource.class).path(String.valueOf(estado.getId())).build())
        .build();
  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Long id) {
    Estado found = manager.find(Estado.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new EstadoVO(found)).build();
  }

  /**
   * @param startPosition
   * @param maxResult
   * @return
   */
  @SuppressWarnings("unchecked")
  @GET
  public Response listAll(@QueryParam("start") final Integer startPosition,
      @QueryParam("max") final Integer maxResult) {
    Query query = manager.createQuery("Select e FROM Estado e");
    List<Estado> resultList = query.getResultList();
    final List<EstadoVO> estadorequestforms =
        resultList.stream().map(EstadoVO::new).collect(Collectors.toList());
    return Response.ok().entity(estadorequestforms).build();
  }

}
