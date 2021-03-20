package com.dev.eficiente.casadocodigo.domain;

import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.model.Autor;
import com.dev.eficiente.casadocodigo.validations.EmailAutor;

public class AutorVO implements Comparable<AutorVO> {

  private Integer id;

  @NotBlank
  private String nome;


  @EmailAutor
  private String email;

  @NotBlank
  private String descricao;


  public AutorVO(Autor autor) {
    this.id = autor.getId();
    this.nome = autor.getNome();
    this.email = autor.getEmail();
    this.descricao = autor.getDescricao();
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
    return String.format("AutorVO [nome=%s, email=%s, descricao=%s]", nome, email, descricao);
  }


  @Override
  public int compareTo(AutorVO o) {
    if (this.email.compareTo(o.getEmail()) == 0)
      return this.nome.compareToIgnoreCase(o.getNome());

    return this.email.compareTo(o.getEmail());
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AutorVO other = (AutorVO) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }



}
