package com.dev.eficiente.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.dev.eficiente.casadocodigo.model.Compra;
import com.dev.eficiente.casadocodigo.model.Estado;
import com.dev.eficiente.casadocodigo.model.Pais;
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

  @Valid
  private PedidoRequestForm pedido;


  @JsonCreator
  public CompraRequestForm(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
      @CPFouCNPJ String documento, @NotBlank String endereco, @NotBlank String complemento,
      @EstadoValido Integer idEstado, @NotBlank String cidade, @NotNull @PaisValido Integer idPais,
      @NotBlank String telefone, @NotBlank String cep, @Valid PedidoRequestForm pedido) {
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
    this.pedido = pedido;
  }

  public String getEmail() {
    return email;
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

  public PedidoRequestForm getPedido() {
    return pedido;
  }

  @Override
  public String toString() {
    return String.format(
        "CompraRequestForm [email=%s, nome=%s, sobrenome=%s, documento=%s, endereco=%s, complemento=%s, idEstado=%s, cidade=%s, idPais=%s, telefone=%s, cep=%s, pedido=%s]",
        email, nome, sobrenome, documento, endereco, complemento, idEstado, cidade, idPais,
        telefone, cep, pedido);
  }

  public Compra toModel(EntityManager manager) {

    Pais pais = manager.find(Pais.class, this.idPais);

    Compra compra = new Compra(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
        this.complemento, this.cidade, pais, this.telefone, this.cep, this.pedido.toModel(manager));

    if (this.idEstado != null) {
      Estado estado = manager.find(Estado.class, this.idEstado);
      compra.setEstado(estado);
    }
    return compra;
  }



}
