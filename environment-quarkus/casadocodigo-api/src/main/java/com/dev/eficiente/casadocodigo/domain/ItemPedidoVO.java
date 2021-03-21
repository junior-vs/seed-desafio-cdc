package com.dev.eficiente.casadocodigo.domain;

import java.math.BigDecimal;
import com.dev.eficiente.casadocodigo.model.ItemPedido;

public class ItemPedidoVO {

  private LivroVO livro;
  private BigDecimal precoDoMomento;
  private int quantidade;

  public ItemPedidoVO(ItemPedido item) {
    //
    livro = new LivroVO(item.getLivro());
    precoDoMomento = item.getPrecoDoMomento();
    quantidade = item.getQuantidade();

  }

  public LivroVO getLivro() {
    return livro;
  }

  public BigDecimal getPrecoDoMomento() {
    return precoDoMomento;
  }

  public int getQuantidade() {
    return quantidade;
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
    ItemPedidoVO other = (ItemPedidoVO) obj;
    if (livro == null) {
      if (other.livro != null)
        return false;
    } else if (!livro.equals(other.livro))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return String.format("ItemPedidoVO [livro=%s, precoDoMomento=%s, quantidade=%s]", livro,
        precoDoMomento, quantidade);
  }



}
