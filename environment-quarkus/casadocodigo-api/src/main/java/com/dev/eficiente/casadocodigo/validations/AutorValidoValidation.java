package com.dev.eficiente.casadocodigo.validations;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Autor;

@ApplicationScoped
public class AutorValidoValidation implements ConstraintValidator<AutorValido, Integer> {

  @PersistenceContext
  EntityManager manager;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if(value == null)
      return true;
    
    Autor found = manager.find(Autor.class, value);
    return found != null;
  }

}
