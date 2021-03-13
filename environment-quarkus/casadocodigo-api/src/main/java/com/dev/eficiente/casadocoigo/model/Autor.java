package com.dev.eficiente.casadocoigo.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Autor {

  @Id
  @GeneratedValue(generator = "AUTOR_SEQ_ID", strategy = IDENTITY)
  @SequenceGenerator(allocationSize = 1, name = "AUTOR_SEQ_ID", sequenceName = "AUTOR_SEQ_ID")
  private Long id;

  private @NotBlank String nome;
  private @NotBlank @Email String email;
  private @NotBlank String descricao;

  public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  /**
   * Construtor criado para atendender Hibernate
   */
  @Deprecated
  public Autor() {
    // Auto-generated constructor stub
  }



}
