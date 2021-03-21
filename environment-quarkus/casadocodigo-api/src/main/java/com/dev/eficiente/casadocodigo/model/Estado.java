package com.dev.eficiente.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.validations.EstadoUnico;

@Entity
public class Estado {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADO_ID_SEQ")
  @SequenceGenerator(allocationSize = 1, name = "ESTADO_ID_SEQ", sequenceName = "ESTADO_ID_SEQ")
  private Integer id;

  @Column(unique = true)
  private @NotBlank String nome;

  @ManyToOne
  private Pais pais;

  public Estado(@NotBlank @EstadoUnico String nome, Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0")
  public Estado() {
    // Auto-generated constructor stub
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Pais getPais() {
    return pais;
  }

  @Override
  public String toString() {
    return String.format("Estado [id=%s, nome=%s]", id, nome);
  }



}
