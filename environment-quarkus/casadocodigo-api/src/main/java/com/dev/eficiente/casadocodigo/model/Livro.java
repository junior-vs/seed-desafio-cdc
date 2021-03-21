package com.dev.eficiente.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

@Entity
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVRO_ID_SEQ")
  @SequenceGenerator(allocationSize = 1, name = "LIVRO_ID_SEQ", sequenceName = "lIVRO_ID_SEQ")
  private Integer id;

  private @NotBlank String titulo;
  private @NotBlank @Length(max = 500) String resumo;
  private @NotBlank String sumario;
  private @NotNull @Min(20) BigDecimal preco;
  private @Min(100) Integer numeroPagina;
  private @NotBlank String isbn;
  private @PastOrPresent LocalDate dtPublicacao;
  @ManyToOne
  private Categoria categoria;
  @ManyToOne
  private Autor autor;

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0.0")
  public Livro() {
    // Auto-generated constructor stub
  }

  public Livro(@NotBlank String titulo, @NotBlank @Max(value = 500) String resumo,
      @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPagina,
      @NotBlank String isbn, @PastOrPresent LocalDate dtPublicacao, Categoria categoria,
      Autor autor) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroPagina = numeroPagina;
    this.isbn = isbn;
    this.dtPublicacao = dtPublicacao;
    this.categoria = categoria;
    this.autor = autor;
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

  public Integer getNumeroPagina() {
    return numeroPagina;
  }

  public String getIsbn() {
    return isbn;
  }

  public LocalDate getDtPublicacao() {
    return dtPublicacao;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Autor getAutor() {
    return autor;
  }

  @Override
  public String toString() {
    return String.format(
        "Livro [id=%s, titulo=%s, resumo=%s, sumario=%s, preco=%s, numeroPagina=%s, isbn=%s, dtPublicacao=%s, categoria=%s, autor=%s]",
        id, titulo, resumo, sumario, preco, numeroPagina, isbn, dtPublicacao, categoria, autor);
  }
  
  



}
