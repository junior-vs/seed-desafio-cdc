package com.dev.eficiente.casadocodigo.form;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import com.dev.eficiente.casadocodigo.model.Compra;
import com.dev.eficiente.casadocodigo.model.ItemPedido;
import com.dev.eficiente.casadocodigo.model.Pedido;
import com.fasterxml.jackson.annotation.JsonCreator;

public class PedidoRequestForm {

  @Positive
  @NotNull
  private BigDecimal total;

  @Valid
  @Size(min = 1)
  private List<ItemRequestForm> itens = new ArrayList<>();

  @JsonCreator
  public PedidoRequestForm(@Positive @NotNull BigDecimal total,
      @Valid @Size(min = 1) List<ItemRequestForm> itens) {
    super();
    this.total = total;
    this.itens = itens;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public List<ItemRequestForm> getItens() {
    return itens;
  }

  @Override
  public String toString() {
    return String.format("PedidoRequestForm [total=%s, itens=%s]", total, itens);
  }

  public Function<Compra, Pedido> toModel(EntityManager manager) {
    Set<ItemPedido> itensColetados =
        itens.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());

    return compra -> {
      Pedido pedido = new Pedido(compra, itensColetados);
      if (!pedido.totalIgual(this.total)) {
        throw new ArithmeticException("Total Não Corresponde ao calculado");
      }
      return pedido;

    };

  }

}
