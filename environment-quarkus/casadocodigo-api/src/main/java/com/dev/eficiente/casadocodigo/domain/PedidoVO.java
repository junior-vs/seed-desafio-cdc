package com.dev.eficiente.casadocodigo.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.dev.eficiente.casadocodigo.model.Pedido;

public class PedidoVO {

  private BigDecimal total;
  private Set<ItemPedidoVO> itensColetados = new HashSet<ItemPedidoVO>();

  public PedidoVO(Pedido pedido) {
    total = pedido.getTotal();
    Set<ItemPedidoVO> collect =
        pedido.getItensColetados().stream().map(ItemPedidoVO::new).collect(Collectors.toSet());
    itensColetados.addAll(collect);
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Set<ItemPedidoVO> getItensColetados() {
    return itensColetados;
  }

}
