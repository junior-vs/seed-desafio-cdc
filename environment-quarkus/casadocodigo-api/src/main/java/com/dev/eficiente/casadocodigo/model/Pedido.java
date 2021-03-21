package com.dev.eficiente.casadocodigo.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_ID_SEQ")
  @SequenceGenerator(allocationSize = 1, name = "PEDIDO_ID_SEQ", sequenceName = "PEDIDO_ID_SEQ")
  private Long id;

  @OneToOne
  private Compra compra;

  private @Positive @NotNull BigDecimal total;

  @Size(min = 1)
  @ElementCollection
  private Set<ItemPedido> itensColetados = new HashSet<>();

  public Pedido(Compra compra, @Size(min = 1) Set<ItemPedido> itensColetados) {
    this.compra = compra;
    this.itensColetados.addAll(itensColetados);
    this.total = itensColetados.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
        (atual, proximo) -> atual.add(proximo));
  }

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0.0")
  public Pedido() {
    // Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return String.format("Pedido [id=%s, total=%s, itensColetados=%s]", id, total, itensColetados);
  }

  public boolean totalIgual(@Positive @NotNull BigDecimal total) {

    BigDecimal totalCalculado = this.itensColetados.stream().map(ItemPedido::total)
        .reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
    System.out.println(totalCalculado.doubleValue());
    return total.doubleValue() == totalCalculado.doubleValue();
  }

  public Long getId() {
    return id;
  }

  public Compra getCompra() {
    return compra;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Set<ItemPedido> getItensColetados() {
    return itensColetados;
  }



}
