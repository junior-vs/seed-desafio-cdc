package com.dev.eficiente.casadocoigo.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.dev.eficiente.casadocoigo.form.request.CategoriaRequestForm;
import com.dev.eficiente.casadocoigo.model.Categoria;

@Path("/categorias")
public class CategoriaResource {

  @PersistenceContext
  private EntityManager manager;


  @POST
  @Transactional
  public Response create(@Valid CategoriaRequestForm novaCategoria) {

    Categoria entity = novaCategoria.map();
    manager.persist(entity);


    return Response.ok(novaCategoria).build();
  }

}
