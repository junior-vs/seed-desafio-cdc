package com.dev.eficiente.casadocodigo.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cupom {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUPOM_ID_SEQ")
  @SequenceGenerator(allocationSize = 1, name = "CUPOM_ID_SEQ", sequenceName = "CUPOM_ID_SEQ")
  private Integer id;

  private @NotBlank String codigo;
  private @Max(100) @NotNull Integer desconto;
  private @NotNull @Future LocalDate validade;

  public Cupom(@NotBlank String codigo, @Max(100) @NotNull Integer desconto,
      @NotNull @Future LocalDate validade) {
    this.codigo = codigo;
    this.desconto = desconto;
    this.validade = validade;
  }

  /**
   * @deprecated Criado para satisfazer o Hiberanate
   */
  @Deprecated(since = "1.0.0")
  public Cupom() {
    // Auto-generated constructor stub
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

}
