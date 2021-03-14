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
import javax.ws.rs.core.UriBuilder;
import com.dev.eficiente.casadocodigo.form.request.PaisRequestForm;
import com.dev.eficiente.casadocodigo.form.vo.PaisVO;
import com.dev.eficiente.casadocodigo.model.Pais;

/**
 * @author Valdir Junior
 *
 */
@RequestScoped
@Path("/paises")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaisEndpoint {

  @PersistenceContext
  EntityManager manager;

  /**
   * @param paisrequestform
   * @return
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Transactional
  public Response create(@Valid final PaisRequestForm paisrequestform) {

    Pais pais = paisrequestform.map();
    manager.persist(pais);

    return Response
        .created(
            UriBuilder.fromResource(PaisEndpoint.class).path(String.valueOf(pais.getId())).build())
        .build();
  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Integer id) {
    Pais found = manager.find(Pais.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new PaisVO(found)).build();
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

    Query createQuery = manager.createQuery("SELECT p FROM Pais p");
    List<Pais> resultList = createQuery.getResultList();
    final List<PaisVO> vos = resultList.stream().map(PaisVO::new).collect(Collectors.toList());

    return Response.ok(vos).build();
  }

}
