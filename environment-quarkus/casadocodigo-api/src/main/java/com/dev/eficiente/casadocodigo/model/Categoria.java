package com.dev.eficiente.casadocodigo.model;

import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

  @GeneratedValue(generator = "CATEGORIA_ID_SEQ", strategy = SEQUENCE)
  @SequenceGenerator(sequenceName = "CATEGORIA_ID_SEQ", allocationSize = 1,
      name = "CATEGORIA_ID_SEQ")
  @Id
  private Integer id;

  @Column(unique = true)
  private @NotBlank String nome;

  public Categoria(
      @NotBlank String nome) {
    this.nome = nome;
  }

  public Categoria() {}

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }



}
