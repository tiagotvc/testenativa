package com.nativa.testenativa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_PATRIMONIO")
public class Patrimonio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer nTombo;
	private String nome;
	private Integer marcaid;
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "PATRIMONIO_MARCA",
	      joinColumns = @JoinColumn(name = "patrimonio_id"),
	      inverseJoinColumns = @JoinColumn(name = "marca_id"))
	
	private List<Marca> marcas = new ArrayList<>();
	
	public Patrimonio() {
	}

	public Patrimonio(Integer nTombo, String nome, Integer marcaid, String descricao) {
		super();
		this.nTombo = nTombo;
		this.nome = nome;
		this.marcaid = marcaid;
		this.descricao = descricao;
	}

	public Integer getnTombo() {
		return nTombo;
	}

	public void setnTombo(Integer nTombo) {
		this.nTombo = nTombo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMarcaid() {
		return marcaid;
	}

	public void setMarcaid(Integer marcaid) {
		this.marcaid = marcaid;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nTombo == null) ? 0 : nTombo.hashCode());
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
		Patrimonio other = (Patrimonio) obj;
		if (nTombo == null) {
			if (other.nTombo != null)
				return false;
		} else if (!nTombo.equals(other.nTombo))
			return false;
		return true;
	}
	
	

}
