package com.dev.eficiente.casadocodigo.validations;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@ApplicationScoped
public class TituloLivroUnicoValidation implements ConstraintValidator<TituloLivroUnico, String> {


  @PersistenceContext
  EntityManager manager;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {


    String select = "SELECT 1 FROM Livro v WHERE v.titulo = :value";

    Query query = manager.createQuery(select);
    query.setParameter("value", value);
    List<?> resultList = query.getResultList();

    return resultList.isEmpty();

  }

}
