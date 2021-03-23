package com.dev.eficiente.casadocodigo.form;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.dev.eficiente.casadocodigo.model.Cupom;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CupomRequestForm {

  @NotBlank
  @CupomUnico
  private String codigo;

  @Max(100)
  @NotNull
  private Integer desconto;

  @NotNull
  @Future
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyy")
  private LocalDate validade;


  @JsonCreator
  public CupomRequestForm(@NotBlank String codigo, @Max(100) @NotNull Integer desconto,
      @NotNull @Future LocalDate validade) {
    super();
    this.codigo = codigo;
    this.desconto = desconto;
    this.validade = validade;
  }



  public Cupom toMode() {
    
    return new Cupom(this.codigo, this.desconto, this.validade);

  }

}
