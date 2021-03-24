package com.dev.eficiente.casadocodigo.validations;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.model.Cupom;

@ApplicationScoped
public class CupomValidoValidation implements ConstraintValidator<CupomValido, String> {


  @PersistenceContext
  EntityManager manager;

  @SuppressWarnings("unchecked")
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    
    if(value==null)
      return true;

    Query query = manager
        .createQuery("Select c from Cupom c where c.codigo = :value and c.validade >= :validade");
    query.setParameter("value", value);
    query.setParameter("validade", LocalDate.now());
    List<Cupom> resultList = query.getResultList();
    return !resultList.isEmpty();
  }

}
