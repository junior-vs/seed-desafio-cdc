package com.dev.eficiente.casadocodigo.form;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import com.dev.eficiente.casadocodigo.model.ItemPedido;
import com.dev.eficiente.casadocodigo.model.Livro;
import com.dev.eficiente.casadocodigo.validations.LivroValido;

public class ItemRequestForm {

  @NotNull
  @LivroValido
  private Integer idLivro;

  @Positive
  private int quantidade;

  public ItemRequestForm(@NotNull @LivroValido Integer idLivro, @Positive int quantidade) {
    super();
    this.idLivro = idLivro;
    this.quantidade = quantidade;
  }

  public Integer getIdLivro() {
    return idLivro;
  }

  public int getQuantidade() {
    return quantidade;
  }

  @Override
  public String toString() {
    return String.format("ItemRequestForm [idLivro=%s, quantidade=%s]", idLivro, quantidade);
  }

  public ItemPedido toModel(EntityManager manager) {
    Livro livro = manager.find(Livro.class, this.idLivro);

    return new ItemPedido(livro, quantidade);
  }

}
