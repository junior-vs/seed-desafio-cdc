package com.dev.eficiente.casadocodigo.domain;

import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.model.Pais;
import com.dev.eficiente.casadocodigo.validations.PaisUnico;

public class PaisVO implements Comparable<PaisVO> {

  private Integer id;

  @NotBlank
  @PaisUnico
  private String nome;

  public PaisVO(Pais pais) {
    this.id = pais.getId();
    this.nome = pais.getNome();
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
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
    PaisVO other = (PaisVO) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }

  @Override
  public int compareTo(PaisVO o) {
    return this.nome.compareToIgnoreCase(o.getNome());
  }

  @Override
  public String toString() {
    return String.format("PaisVO [id=%s, nome=%s]", id, nome);
  }


}
