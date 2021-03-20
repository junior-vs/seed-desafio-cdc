package com.dev.eficiente.casadocodigo.resources;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dev.eficiente.casadocodigo.form.CompraRequestForm;

@RequestScoped
@Path("/compra")
public class CompraResource {

  @PersistenceContext
  EntityManager manager;

  Logger LOGGER = LoggerFactory.getLogger(CompraResource.class);

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String realizar(@Valid final CompraRequestForm compra) {

    LOGGER.info("teste");

    return compra.toString();
  }


}
