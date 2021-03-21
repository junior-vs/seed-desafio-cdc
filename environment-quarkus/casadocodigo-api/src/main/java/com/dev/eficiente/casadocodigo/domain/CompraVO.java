package com.dev.eficiente.casadocodigo.domain;

import com.dev.eficiente.casadocodigo.model.Compra;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CompraVO {

  private Long id;
  private String nome;
  private String sobrenome;
  private String documento;
  private String email;
  private String telefone;
  private String endereco;
  private String complemento;
  private String cidade;
  private EstadoVO estado;
  private PaisVO pais;
  private String cep;
  private PedidoVO pedido;

  @JsonCreator
  public CompraVO(Compra compra) {
    id = compra.getId();
    documento = compra.getDocumento();
    email = compra.getEmail();
    endereco = compra.getEndereco();
    complemento = compra.getComplemento();
    cidade = compra.getCidade();
    cep = compra.getCep();
    nome = compra.getNome();
    sobrenome = compra.getSobrenome();
    pais = new PaisVO(compra.getPais());
    telefone = compra.getTelefone();
    estado = new EstadoVO(compra.getEstado());
    pedido = new PedidoVO(compra.getPedido());
  }

  public Long getId() {
    return id;
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

  public String getEmail() {
    return email;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public EstadoVO getEstado() {
    return estado;
  }

  public PaisVO getPais() {
    return pais;
  }

  public String getCep() {
    return cep;
  }

  public PedidoVO getPedido() {
    return pedido;
  }

  @Override
  public String toString() {
    return String.format(
        "CompraVO [id=%s, nome=%s, sobrenome=%s, documento=%s, email=%s, telefone=%s, endereco=%s, complemento=%s, cidade=%s, estado=%s, pais=%s, cep=%s, pedido=%s]",
        id, nome, sobrenome, documento, email, telefone, endereco, complemento, cidade, estado,
        pais, cep, pedido);
  }



}
