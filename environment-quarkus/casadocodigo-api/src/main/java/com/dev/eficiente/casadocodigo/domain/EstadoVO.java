package com.dev.eficiente.casadocodigo.domain;

import com.dev.eficiente.casadocodigo.model.Estado;

public class EstadoVO {

  private Integer id;
  private String nome;
  private PaisVO pais;

  public EstadoVO(Estado estado) {
    this.id = estado.getId();
    this.nome = estado.getNome();
    pais = new PaisVO(estado.getPais());
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public PaisVO getPais() {
    return pais;
  }

  @Override
  public String toString() {
    return String.format("EstadoVO [id=%s, nome=%s, pais=%s]", id, nome, pais);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
    EstadoVO other = (EstadoVO) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (pais == null) {
      if (other.pais != null)
        return false;
    } else if (!pais.equals(other.pais))
      return false;
    return true;
  }



}
