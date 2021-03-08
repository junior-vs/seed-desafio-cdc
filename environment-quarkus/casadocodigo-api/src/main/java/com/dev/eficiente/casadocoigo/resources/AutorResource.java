package com.dev.eficiente.casadocoigo.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import com.dev.eficiente.casadocoigo.form.request.AutorRequestForm;
import com.dev.eficiente.casadocoigo.model.Autor;

@Path("/autores")
@ApplicationScoped
public class AutorResource {

  @PersistenceContext
  private EntityManager manager;


  @POST
  @Transactional
  public String criaAutor(@Valid AutorRequestForm autor) {

    Autor entity = autor.map();
    manager.persist(entity);

    return autor.toString();

  }

}
