package com.dev.eficiente.casadocodigo.validations;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.dev.eficiente.casadocodigo.form.CompraRequestForm;
import com.dev.eficiente.casadocodigo.model.Pais;

@ApplicationScoped
public class EstadoPertenceAPaisValidator
    implements ConstraintValidator<EstadoPertenceAPais, CompraRequestForm> {

  @PersistenceContext
  EntityManager manager;


  @Override
  public boolean isValid(CompraRequestForm value, ConstraintValidatorContext context) {
    if (value.getIdPais() == null || value.getIdEstado() == null  ) {
      return true;
    }

    Query query =
        manager.createQuery("SELECT e FROM Estado e WHERE e.id = :id and e.pais = :idpais");
    query.setParameter("id", value.getIdEstado());
    query.setParameter("idpais", new Pais(value.getIdPais()));
    List<?> resultList = query.getResultList();

    return !resultList.isEmpty();
  }

}
