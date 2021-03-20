package com.dev.eficiente.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.model.Pais;
import com.dev.eficiente.casadocodigo.validations.PaisUnico;
import com.fasterxml.jackson.annotation.JsonCreator;

public class PaisRequestForm {

  @NotBlank
  @PaisUnico
  private String nome;

  @JsonCreator
  public PaisRequestForm(@NotBlank @PaisUnico String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public Pais map() {
    //
    return new Pais(nome);
  }

}
