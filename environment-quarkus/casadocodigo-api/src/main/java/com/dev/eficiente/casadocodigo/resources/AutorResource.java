package com.dev.eficiente.casadocodigo.resources;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
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
import com.dev.eficiente.casadocodigo.domain.AutorVO;
import com.dev.eficiente.casadocodigo.form.AutorRequestForm;
import com.dev.eficiente.casadocodigo.model.Autor;

@Path("/autores")
@ApplicationScoped
public class AutorResource {

  @PersistenceContext
  EntityManager manager;


  @POST
  @Transactional
  public Response criaAutor(@Valid AutorRequestForm autor) {

    Autor entity = autor.map();
    manager.persist(entity);

    return Response.ok(autor).build();

  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Integer id) {
    Autor found = manager.find(Autor.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new AutorVO(found)).build();
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

    Query query = manager.createQuery("Select a from Autor a");
    List<Autor> resultList = query.getResultList();

    final List<AutorVO> autoresvo =
        resultList.stream().map(AutorVO::new).collect(Collectors.toList());

    return Response.ok(autoresvo).build();
  }

}
