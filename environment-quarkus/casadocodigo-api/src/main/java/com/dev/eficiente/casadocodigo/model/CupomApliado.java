package com.dev.eficiente.casadocodigo.model;

import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class CupomApliado {

  @ManyToOne
  private Cupom cupom;
  @Positive
  @NotNull
  private Integer descontoAplicadoMomento;
  @Future
  private LocalDate validade;

  public CupomApliado(Cupom cupom) {
    this.cupom = cupom;
    this.descontoAplicadoMomento = cupom.getDesconto();
    this.validade = cupom.getValidade();
  }

  /**
   * @deprecated criado para satisfazer o hibernate
   */
  @Deprecated(since = "1.0")
  public CupomApliado() {}

  public Cupom getCupom() {
    return cupom;
  }

  public Integer getDescontoAplicadoMomento() {
    return descontoAplicadoMomento;
  }

  public LocalDate getValidade() {
    return validade;
  }
}
