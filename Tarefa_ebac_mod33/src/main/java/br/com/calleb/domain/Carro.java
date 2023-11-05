package br.com.calleb.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author calle
 * 
 */
@Entity
@Table(name = "TB_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
	@SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "IDENTIFICADOR", length = 10, nullable = false, unique = true)
	private String identificador;

	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;

	@OneToOne(mappedBy = "carro")
	private Loja loja;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "TB_CARRO_ACESSORIO", joinColumns = { @JoinColumn(name = "id_carro_fk") }, inverseJoinColumns = {
			@JoinColumn(name = "id_acessorio_fk") })
	private List<Acessorio> acessorios;

	public Carro() {
		this.acessorios = new ArrayList<Acessorio>();
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

	public String getNome() {
		return nome;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	public void add(Acessorio acess) {
		this.acessorios.add(acess);
	}
}
