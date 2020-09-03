package com.nativa.testenativa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="TB_MARCA")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer marcaid;
	private String nome;
	
	@ManyToMany(mappedBy ="marcas")
	public List<Patrimonio> patrimonios = new ArrayList<>();
	
	public Marca() {
	}

	public Marca( Integer marcaid, String nome) {
		super();
		this.marcaid = marcaid;
		this.nome = nome;
	}
	

	public Integer getMarcaId() {
		return marcaid;
	}

	public void setMarcaId(Integer marcaid) {
		this.marcaid = marcaid;
	}

	public String getNome() {
		return nome;
	}
	

	public List<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

	public void setPatrimonios(List<Patrimonio> patrimonios) {
		this.patrimonios = patrimonios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marcaid == null) ? 0 : marcaid.hashCode());
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
		Marca other = (Marca) obj;
		if (marcaid == null) {
			if (other.marcaid != null)
				return false;
		} else if (!marcaid.equals(other.marcaid))
			return false;
		return true;
	}
	
 
}
