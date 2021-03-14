package com.dev.eficiente.casadocodigo.form.request;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Pais;

@ApplicationScoped
public class PaisValidoValidation implements ConstraintValidator<PaisValido, Integer> {

  @PersistenceContext
  EntityManager manager;


  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    Pais fond = manager.find(Pais.class, value);
    return fond != null;
  }

}
