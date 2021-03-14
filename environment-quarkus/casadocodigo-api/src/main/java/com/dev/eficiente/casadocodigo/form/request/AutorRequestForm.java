package com.dev.eficiente.casadocodigo.form.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.model.Autor;
import com.dev.eficiente.casadocodigo.validations.EmailAutor;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AutorRequestForm {

  @NotBlank
  private String nome;

 
  @EmailAutor
  private String email;

  @NotBlank
  private String descricao;

  @JsonCreator
  public AutorRequestForm(@NotBlank String nome, @NotBlank @Email String email,
      @NotBlank String descricao) {
    super();
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return String.format("AutorRequestForm [nome=%s, email=%s, descricao=%s]", nome, email,
        descricao);
  }

  public Autor map() {
    return new Autor(nome, email, descricao);
  }



}
