package com.dev.eficiente.casadocodigo.validations;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Livro;

@ApplicationScoped
public class LivroValidoValidation implements ConstraintValidator<LivroValido, Integer> {


  @PersistenceContext
  EntityManager manager;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null)
      return true;

    Livro found = manager.find(Livro.class, value);
    return found != null;
  }
}
