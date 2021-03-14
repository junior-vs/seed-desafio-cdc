package com.dev.eficiente.casadocodigo.validations;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@ApplicationScoped
public class EmailAutorValidation implements ConstraintValidator<EmailAutor, String> {


  @PersistenceContext
  private EntityManager manager;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {


    String select = "SELECT 1 FROM Autor a WHERE a.email = :value";

    Query query = manager.createQuery(select);
    query.setParameter("value", value);
    List<?> resultList = query.getResultList();

    return resultList.isEmpty();

  }

}
