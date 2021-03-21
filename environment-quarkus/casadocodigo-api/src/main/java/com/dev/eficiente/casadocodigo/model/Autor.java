package com.dev.eficiente.casadocodigo.model;

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
  private Integer id;

  private @NotBlank String nome;
  private @NotBlank @Email String email;
  private @NotBlank String descricao;

  public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0")
  public Autor() {
    // Auto-generated constructor stub
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getDescricao() {
    return descricao;
  }

  @Override
  public String toString() {
    return String.format("Autor [id=%s, nome=%s, email=%s, descricao=%s]", id, nome, email,
        descricao);
  }



}
