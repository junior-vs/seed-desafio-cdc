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
import com.dev.eficiente.casadocodigo.domain.CupomVO;
import com.dev.eficiente.casadocodigo.form.CupomRequestForm;
import com.dev.eficiente.casadocodigo.model.Cupom;

@RequestScoped
@Path("/cupons")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CupomResource {

  @PersistenceContext
  EntityManager manager;

  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  @Transactional
  public Response create(@Valid final CupomRequestForm cupom) {

    Cupom entity = cupom.toMode();
    manager.persist(entity);
    return Response.created(
        UriBuilder.fromResource(CupomResource.class).path(String.valueOf(entity.getId())).build())
        .build();
  }

  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Integer id) {
    Cupom found = manager.find(Cupom.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new CupomVO(found)).build();
  }

  @SuppressWarnings("unchecked")
  @GET
  public Response listAll(@QueryParam("start") final Integer startPosition,
      @QueryParam("max") final Integer maxResult) {
    Query query = manager.createQuery("Select c From Cupom c");
    List<Cupom> resultList = query.getResultList();
    List<CupomVO> collect = resultList.stream().map(CupomVO::new).collect(Collectors.toList());

    return Response.ok().entity(collect).build();
  }

}
