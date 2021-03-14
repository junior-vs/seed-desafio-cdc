package com.dev.eficiente.casadocodigo.form.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.dev.eficiente.casadocodigo.model.Estado;
import com.dev.eficiente.casadocodigo.model.Pais;
import com.dev.eficiente.casadocodigo.validations.EstadoUnico;

public class EstadoRequestForm {

  @NotBlank
  @EstadoUnico
  private String nome;

  @NotNull
  @PaisValido
  private Integer idPais;

  public EstadoRequestForm(@NotBlank @EstadoUnico String nome,
      @NotBlank @PaisValido Integer idPais) {
    super();
    this.nome = nome;
    this.idPais = idPais;
  }

  @Override
  public String toString() {
    return String.format("EstadoRequestForm [nome=%s, idPais=%s]", nome, idPais);
  }

  public String getNome() {
    return nome;
  }

  public Integer getIdPais() {
    return idPais;
  }

  public Estado map(EntityManager manager) {
    Pais paisFound = manager.find(Pais.class, this.idPais);
    return new Estado(this.nome, paisFound);
  }

}
