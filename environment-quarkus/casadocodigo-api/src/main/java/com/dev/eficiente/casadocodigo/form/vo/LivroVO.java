package com.dev.eficiente.casadocodigo.form.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;
import com.dev.eficiente.casadocodigo.model.Livro;
import com.dev.eficiente.casadocodigo.validations.AutorValido;
import com.dev.eficiente.casadocodigo.validations.CategoriaValido;
import com.dev.eficiente.casadocodigo.validations.ISBNUnico;
import com.dev.eficiente.casadocodigo.validations.TituloLivroUnico;

public class LivroVO implements Comparable<LivroVO> {

  private Integer id;


  @TituloLivroUnico
  @NotBlank
  private String titulo;

  @NotBlank
  @Length(max = 500)
  private String resumo;

  @NotBlank
  private String sumario;

  @NotNull
  @Min(20)
  private BigDecimal preco;

  @Min(100)
  private Integer numeroPaginas;

  @ISBNUnico
  private String isbn;

  @PastOrPresent
  private LocalDate publicacao;

  // TemQExistir
  @CategoriaValido
  @NotNull
  private CategoriaVO categoria;

  // TemQExistir
  @AutorValido
  @NotNull
  private AutorVO autor;


  public LivroVO(Livro found) {
    this.id = found.getId();
    this.titulo = found.getTitulo();
    this.resumo = found.getResumo();
    this.sumario = found.getSumario();
    this.preco = found.getPreco();
    this.numeroPaginas = found.getNumeroPagina();
    this.isbn = found.getIsbn();
    this.publicacao = found.getDtPublicacao();
    this.categoria = new CategoriaVO(found.getCategoria());
    this.autor = new AutorVO(found.getAutor());
  }


  public Integer getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }


  public String getResumo() {
    return resumo;
  }


  public String getSumario() {
    return sumario;
  }


  public BigDecimal getPreco() {
    return preco;
  }


  public Integer getNumeroPaginas() {
    return numeroPaginas;
  }


  public String getIsbn() {
    return isbn;
  }


  public LocalDate getPublicacao() {
    return publicacao;
  }


  public CategoriaVO getCategoria() {
    return categoria;
  }


  public AutorVO getAutor() {
    return autor;
  }


  @Override
  public String toString() {
    return String.format(
        "LivroVO [titulo=%s, resumo=%s, sumario=%s, preco=%s, numeroPaginas=%s, isbn=%s, publicacao=%s, categoria=%s, autor=%s]",
        titulo, resumo, sumario, preco, numeroPaginas, isbn, publicacao, categoria, autor);
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
    LivroVO other = (LivroVO) obj;
    if (isbn == null) {
      if (other.isbn != null)
        return false;
    } else if (!isbn.equals(other.isbn))
      return false;
    return true;
  }


  @Override
  public int compareTo(LivroVO o) {
    return this.titulo.compareToIgnoreCase(o.getTitulo());
  }



}
