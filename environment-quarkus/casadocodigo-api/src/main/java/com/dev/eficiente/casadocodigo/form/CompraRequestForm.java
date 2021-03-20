package com.dev.eficiente.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.dev.eficiente.casadocodigo.validations.CPFouCNPJ;
import com.dev.eficiente.casadocodigo.validations.EstadoPertenceAPais;
import com.dev.eficiente.casadocodigo.validations.EstadoValido;
import com.dev.eficiente.casadocodigo.validations.PaisValido;
import com.fasterxml.jackson.annotation.JsonCreator;

@EstadoPertenceAPais
public class CompraRequestForm {

  @Email
  private String email;

  @NotBlank
  private String nome;

  @NotBlank
  private String sobrenome;

  // CPF ou CNPJ
  @CPFouCNPJ
  private String documento;

  @NotBlank
  private String endereco;

  @NotBlank
  private String complemento;

  @EstadoValido
  private Integer idEstado;

  @NotBlank
  private String cidade;

  @PaisValido
  @NotNull
  private Integer idPais;

  @NotBlank
  private String telefone;

  @NotBlank
  private String cep;

  @JsonCreator


  public String getEmail() {
    return email;
  }

  public CompraRequestForm(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
      @CPFouCNPJ String documento, @NotBlank String endereco, @NotBlank String complemento,
      @EstadoValido Integer idEstado, @NotBlank String cidade, @NotNull @PaisValido Integer idPais,
      @NotBlank String telefone, @NotBlank String cep) {
    super();
    this.email = email;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.documento = documento;
    this.endereco = endereco;
    this.complemento = complemento;
    this.idEstado = idEstado;
    this.cidade = cidade;
    this.idPais = idPais;
    this.telefone = telefone;
    this.cep = cep;
  }

  public String getNome() {
    return nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public String getDocumento() {
    return documento;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public Integer getIdEstado() {
    return idEstado;
  }

  public String getCidade() {
    return cidade;
  }

  public Integer getIdPais() {
    return idPais;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getCep() {
    return cep;
  }

  @Override
  public String toString() {
    return String.format(
        "CompraRequestForm [email=%s, nome=%s, sobrenome=%s, documento=%s, endereco=%s, complemento=%s, idEstado=%s, cidade=%s, idPais=%s, telefone=%s, cep=%s]",
        email, nome, sobrenome, documento, endereco, complemento, idEstado, cidade, idPais,
        telefone, cep);
  }



}
