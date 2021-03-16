package com.dev.eficiente.casadocodigo.resources;

import java.util.List;
import java.util.stream.Collectors;
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
import com.dev.eficiente.casadocodigo.form.request.CategoriaRequestForm;
import com.dev.eficiente.casadocodigo.form.vo.CategoriaVO;
import com.dev.eficiente.casadocodigo.model.Categoria;

@Path("/categorias")
public class CategoriaResource {

  @PersistenceContext
  EntityManager manager;


  @POST
  @Transactional
  public Response create(@Valid CategoriaRequestForm novaCategoria) {

    Categoria entity = novaCategoria.map();
    manager.persist(entity);


    return Response.ok(novaCategoria).build();
  }


  /**
   * @param id
   * @return
   */
  @GET
  @Path("/{id:[0-9][0-9]*}")
  public Response findById(@PathParam("id") final Integer id) {
    Categoria found = manager.find(Categoria.class, id);
    if (found == null) {
      return Response.status(Status.NOT_FOUND).build();
    }
    return Response.ok(new CategoriaVO(found)).build();
  }

  /**
   * @param startPosition
   * @param maxResult
   * @return
   */
  @GET
  public Response listAll(@QueryParam("start") final Integer startPosition,
      @QueryParam("max") final Integer maxResult) {

    Query query = manager.createQuery("Select c from Categoria c");
    List<Categoria> resultList = query.getResultList();

    final List<CategoriaVO> categoriasvo =
        resultList.stream().map(CategoriaVO::new).collect(Collectors.toList());
    
    return Response.ok(categoriasvo).build();
  }


  
}
