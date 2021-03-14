package com.dev.eficiente.casadocodigo.validations;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Categoria;

@ApplicationScoped
public class CategoriaValidoValidation implements ConstraintValidator<CategoriaValido, Integer> {

  @PersistenceContext
  EntityManager manager;

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    Categoria found = manager.find(Categoria.class, value);
    return found != null;
  }
}
