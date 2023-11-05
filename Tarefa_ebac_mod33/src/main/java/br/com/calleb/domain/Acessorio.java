package br.com.calleb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author calle
 * 
 */
@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acess_seq")
	@SequenceGenerator(name = "acess_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "IDENTIFICADOR", length = 10, nullable = false, unique = true)
	private String identificador;

	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;

	@ManyToMany(mappedBy = "acessorios")
	private List<Carro> carros;

	public Acessorio() {
		this.carros = new ArrayList<Carro>();
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public void add(Carro carro) {
		this.carros.add(carro);
	}
}
