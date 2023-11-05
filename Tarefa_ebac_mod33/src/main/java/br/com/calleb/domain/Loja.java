package br.com.calleb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author calle
 * 
 */
@Entity
@Table(name = "TB_LOJA")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja_seq")
	@SequenceGenerator(name = "loja_seq", sequenceName = "sq_loja", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "IDENTIFICADOR", length = 10, nullable = false, unique = true)
	private String identificador;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "status", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_marca_fk", foreignKey = @ForeignKey(name = "fk_marca_loja"), referencedColumnName = "id", nullable = false)
	private Marca marca;

	@OneToOne
	@JoinColumn(name = "id_carro_fk", foreignKey = @ForeignKey(name = "fk_carro_loja"), referencedColumnName = "id", nullable = false)
	private Carro carro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
}
