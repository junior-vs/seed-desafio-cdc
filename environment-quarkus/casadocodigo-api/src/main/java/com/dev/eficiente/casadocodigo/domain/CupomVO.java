package com.dev.eficiente.casadocodigo.domain;

import java.time.LocalDate;
import com.dev.eficiente.casadocodigo.model.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CupomVO {

  private Integer id;
  private String codigo;
  private Integer desconto;

  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate validade;

  public CupomVO(Cupom cupom) {
    this.id = cupom.getId();
    this.codigo = cupom.getCodigo();
    this.desconto = cupom.getDesconto();
    this.validade = cupom.getValidade();
  }

  public Integer getId() {
    return id;
  }

  public String getCodigo() {
    return codigo;
  }

  public Integer getDesconto() {
    return desconto;
  }

  public LocalDate getValidade() {
    return validade;
  }

  @Override
  public String toString() {
    return String.format("CupomVO [id=%s, codigo=%s, desconto=%s, validade=%s]", id, codigo,
        desconto, validade);
  }



}
