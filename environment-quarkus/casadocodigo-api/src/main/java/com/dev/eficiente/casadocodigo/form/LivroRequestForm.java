package com.dev.eficiente.casadocodigo.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;
import com.dev.eficiente.casadocodigo.model.Autor;
import com.dev.eficiente.casadocodigo.model.Categoria;
import com.dev.eficiente.casadocodigo.model.Livro;
import com.dev.eficiente.casadocodigo.validations.AutorValido;
import com.dev.eficiente.casadocodigo.validations.CategoriaValido;
import com.dev.eficiente.casadocodigo.validations.ISBNUnico;
import com.dev.eficiente.casadocodigo.validations.TituloLivroUnico;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * CDD 3
 * @author Valdir Junior
 *
 */
public class LivroRequestForm {

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
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate publicacao;

  // TemQExistir
  @CategoriaValido
  @NotNull
  private Integer idCategoria;

  // TemQExistir
  @AutorValido
  @NotNull
  private Integer idAutor;


  @JsonCreator
  public LivroRequestForm(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo,
      @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas,
      @NotBlank String isbn, @PastOrPresent LocalDate publicacao, @NotNull Integer idCategoria,
      @NotNull Integer idAutor) {
    super();
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroPaginas = numeroPaginas;
    this.isbn = isbn;
    this.publicacao = publicacao;
    this.idCategoria = idCategoria;
    this.idAutor = idAutor;
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



  public Integer getIdCategoria() {
    return idCategoria;
  }



  public Integer getIdAutor() {
    return idAutor;
  }



  @Override
  public String toString() {
    return String.format(
        "LivroRequestForm [titulo=%s, resumo=%s, sumario=%s, preco=%s, numeroPagina=%s, isbn=%s, dtPublicacao=%s, categoria=%s, idAutor=%s]",
        titulo, resumo, sumario, preco, numeroPaginas, isbn, publicacao, idCategoria, idAutor);
  }



  public Livro map(EntityManager manager) {

    Categoria categoriaEntity = manager.find(Categoria.class, this.idCategoria);
    Autor autorEntity = manager.find(Autor.class, this.idAutor);

    return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, publicacao,
        categoriaEntity, autorEntity);

  }


}
