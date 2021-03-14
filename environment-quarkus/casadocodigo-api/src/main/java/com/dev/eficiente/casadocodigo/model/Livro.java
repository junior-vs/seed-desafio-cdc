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
  private Categoria categoriaEntity;
  @ManyToOne
  private Autor autorEntity;

  /**
   * Construtor criado para atender Hibernate
   */
  @Deprecated
  public Livro() {
    // Auto-generated constructor stub
  }

  public Livro(@NotBlank String titulo, @NotBlank @Max(value = 500) String resumo,
      @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @Min(100) Integer numeroPagina,
      @NotBlank String isbn, @PastOrPresent LocalDate dtPublicacao, Categoria categoriaEntity,
      Autor autorEntity) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroPagina = numeroPagina;
    this.isbn = isbn;
    this.dtPublicacao = dtPublicacao;
    this.categoriaEntity = categoriaEntity;
    this.autorEntity = autorEntity;
  }

  public Integer getId() {
    return id;
  }

}
