/**
 * 
 */
package com.dev.eficiente.casadocodigo.resources;

import java.net.URI;
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
import com.dev.eficiente.casadocodigo.domain.LivroVO;
import com.dev.eficiente.casadocodigo.form.LivroRequestForm;
import com.dev.eficiente.casadocodigo.model.Livro;

/**
 * @author Valdir Junior
 *
 *         CDD 2
 */
@RequestScoped
@Path("/livros")
public class LivroResource {

  @PersistenceContext
  EntityManager manager;

  /**
   * @param livrorequestform
   * @return
   * 
   */
  @POST
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(@Valid final LivroRequestForm livro) {

    Livro livroEntity = livro.map(manager);
    manager.persist(livroEntity);

    URI uri = UriBuilder.fromResource(LivroResource.class).path(String.valueOf(livroEntity.getId()))
        .build();

    return Response.created(uri).entity(new LivroVO(livroEntity)).build();
  }

  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Integer id) {
    Livro found = manager.find(Livro.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new LivroVO(found)).build();
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

    Query query = manager.createQuery("Select l from Livro l");
    List<Livro> resultList = query.getResultList();

    final List<LivroVO> livrosvo =
        resultList.stream().map(LivroVO::new).collect(Collectors.toList());

    return Response.ok(livrosvo).build();
  }

}
