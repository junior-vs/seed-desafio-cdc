package com.dev.eficiente.casadocodigo.model;

import java.math.BigDecimal;
import java.util.function.Function;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.dev.eficiente.casadocodigo.validations.CPFouCNPJ;

@Entity
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPRA_ID_SEQ")
  private Long id;

  private @Email String email;
  private @NotBlank String nome;
  private @NotBlank String sobrenome;
  private @CPFouCNPJ String documento;
  private @NotBlank String endereco;
  private @NotBlank String complemento;
  private @NotBlank String cidade;
  @ManyToOne
  private Estado estado;
  @ManyToOne
  private Pais pais;
  private @NotBlank String telefone;
  private @NotBlank String cep;
  @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
  private Pedido pedido;

  private BigDecimal totalCobrado;

  @Embedded
  private CupomApliado cupomAplicado;

  public Compra(@Email String email, @NotBlank String nome, @NotBlank String sobrenome,
      @CPFouCNPJ String documento, @NotBlank String endereco, @NotBlank String complemento,
      @NotBlank String cidade, Pais pais, @NotBlank String telefone, @NotBlank String cep,
      Function<Compra, Pedido> funcaoCriacaoPedido) {
    this.email = email;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.documento = documento;
    this.endereco = endereco;
    this.complemento = complemento;
    this.cidade = cidade;
    this.pais = pais;
    this.telefone = telefone;
    this.cep = cep;
    this.pedido = funcaoCriacaoPedido.apply(this);
    this.totalCobrado = calculaTotalACobrar(pedido.getTotal());

  }

  private BigDecimal calculaTotalACobrar(BigDecimal total) {

    int desconto =
        (this.cupomAplicado == null) ? 0 : this.cupomAplicado.getDescontoAplicadoMomento();

    BigDecimal t1 = total.multiply(new BigDecimal(desconto));
    BigDecimal t2 = t1.divide(new BigDecimal(100));
    return total.subtract(t2);

  }

  /**
   * @deprecated Construtor criado para atendeder Hibernate
   */
  @Deprecated(since = "1.0")
  public Compra() {
    // Auto-generated constructor stub
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return String.format(
        "Compra [id=%s, email=%s, nome=%s, sobrenome=%s, documento=%s, endereco=%s, complemento=%s, cidade=%s, estado=%s, pais=%s, telefone=%s, cep=%s, pedido=%s]",
        id, email, nome, sobrenome, documento, endereco, complemento, cidade, estado, pais,
        telefone, cep, pedido);
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public String getDocumento() {
    return documento;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public Estado getEstado() {
    return estado;
  }

  public Pais getPais() {
    return pais;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getCep() {
    return cep;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public BigDecimal getTotalCobrado() {
    return totalCobrado;
  }

  public CupomApliado getCupomAplicado() {
    return cupomAplicado;
  }

  public void apicaCupom(Cupom cupom) {

    if (!cupom.valido()) {
      throw new IllegalArgumentException("cupom Não é valido");
    }
    this.cupomAplicado = new CupomApliado(cupom);
    this.totalCobrado = calculaTotalACobrar(pedido.getTotal());
  }



}
