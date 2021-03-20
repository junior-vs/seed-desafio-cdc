package com.dev.eficiente.casadocodigo.form;

import com.dev.eficiente.casadocodigo.model.Categoria;
import com.dev.eficiente.casadocodigo.validations.CategoriaUnica;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequestForm {

  
  @CategoriaUnica
  private String nome;

  @JsonCreator
  public CategoriaRequestForm(@CategoriaUnica String nome) {
    super();
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return String.format("CategoriaRequestForm [nome=%s]", nome);
  }

  public Categoria map() {
    return new Categoria(this.nome);
  }



}
