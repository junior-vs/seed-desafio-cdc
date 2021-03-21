package com.dev.eficiente.casadocodigo.model;

import java.math.BigDecimal;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Embeddable
public class ItemPedido {

  @ManyToOne
  private Livro livro;

  private @Positive int quantidade;

  @Positive
  private BigDecimal precoDoMomento;

  public ItemPedido(Livro livro, @Positive int quantidade) {
    this.livro = livro;
    this.quantidade = quantidade;
    this.precoDoMomento = livro.getPreco();
  }

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0")
  public ItemPedido() {}

  @Override
  public String toString() {
    return String.format("ItemPedido [livro=%s, quantidade=%s]", livro, quantidade);
  }

  public BigDecimal total() {
    return this.precoDoMomento.multiply(new BigDecimal(quantidade));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((livro == null) ? 0 : livro.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemPedido other = (ItemPedido) obj;
    if (livro == null) {
      if (other.livro != null)
        return false;
    } else if (!livro.equals(other.livro))
      return false;
    return true;
  }



}
