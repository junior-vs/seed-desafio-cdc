package com.dev.eficiente.casadocodigo.resources;

import java.net.URI;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dev.eficiente.casadocodigo.domain.CompraVO;
import com.dev.eficiente.casadocodigo.form.CompraRequestForm;
import com.dev.eficiente.casadocodigo.model.Compra;

@RequestScoped
@Path("/compra")
public class CompraResource {

  @PersistenceContext
  EntityManager manager;

  Logger logger = LoggerFactory.getLogger(CompraResource.class);

  @Transactional
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response realizar(@Valid final CompraRequestForm compra) {

    logger.info("teste");

    Compra compraEntity = compra.toModel(manager);
    manager.persist(compraEntity);


    URI path =
        UriBuilder.fromResource(Compra.class).path(String.valueOf(compraEntity.getId())).build();

    return Response.created(path).entity(new CompraVO(compraEntity)).build();
  }

  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Long id) {
    Compra found = manager.find(Compra.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new CompraVO(found)).build();
  }


}
