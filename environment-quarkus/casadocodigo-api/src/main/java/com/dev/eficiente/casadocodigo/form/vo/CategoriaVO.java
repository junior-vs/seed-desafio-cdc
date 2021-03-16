package com.dev.eficiente.casadocodigo.form.vo;

import com.dev.eficiente.casadocodigo.model.Categoria;
import com.dev.eficiente.casadocodigo.validations.CategoriaUnica;

public class CategoriaVO implements Comparable<CategoriaVO> {

  private Integer id;

  @CategoriaUnica
  private String nome;

  public CategoriaVO(Categoria categoria) {
    this.id = categoria.getId();
    this.nome = categoria.getNome();
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return String.format("CategoriaVO [nome=%s]", nome);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    CategoriaVO other = (CategoriaVO) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }

  @Override
  public int compareTo(CategoriaVO o) {
    return this.nome.compareToIgnoreCase(o.getNome());
  }



}
