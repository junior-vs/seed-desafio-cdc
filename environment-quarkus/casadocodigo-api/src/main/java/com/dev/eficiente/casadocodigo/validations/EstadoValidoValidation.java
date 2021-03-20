package com.dev.eficiente.casadocodigo.validations;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Estado;

@ApplicationScoped
public class EstadoValidoValidation implements ConstraintValidator<EstadoValido, Integer> {

  @PersistenceContext
  EntityManager manager;


  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {

    if (value == null)
      return true;

    Estado fond = manager.find(Estado.class, value);
    return fond != null;
  }
}
