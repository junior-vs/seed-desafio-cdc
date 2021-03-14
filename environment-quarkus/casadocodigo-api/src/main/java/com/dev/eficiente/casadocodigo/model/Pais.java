package com.dev.eficiente.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAIS_ID_SEQ")
  @SequenceGenerator(allocationSize = 1, sequenceName = "PAIS_ID_SEQ", name = "PAIS_ID_SEQ")
  private Integer id;

  @NotBlank
  @Column(unique = true)
  private String nome;

  public Pais(@NotBlank String nome) {
    super();
    this.nome = nome;
  }

  @Deprecated
  public Pais() {
    // Auto-generated constructor stub
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

}
