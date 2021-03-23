package com.dev.eficiente.casadocodigo.domain;

import com.dev.eficiente.casadocodigo.model.CupomApliado;

public class CupomApliadoVO {

  private Integer desconto;

  public CupomApliadoVO(CupomApliado cupomAplicado) {
    desconto = cupomAplicado.getDescontoAplicadoMomento();

  }

  public Integer getDesconto() {
    return desconto;
  }

}
