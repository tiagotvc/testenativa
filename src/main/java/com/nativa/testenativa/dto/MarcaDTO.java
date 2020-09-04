package com.nativa.testenativa.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nativa.testenativa.domain.Marca;

public class MarcaDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	@NotEmpty(message="Preenchimento Obrigatório")
	private Integer marcaid;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=80, message = " O Tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

    public MarcaDTO() {
	   
    }
    
    public MarcaDTO(Marca obj) {
    	marcaid = obj.getMarcaId();
    	nome = obj.getNome();
    }



    public Integer getMarcaid() {
	   return marcaid;
 }



   public void setMarcaid(Integer marcaid) {
	   this.marcaid = marcaid;
  }



   public String getNome() {
	   return nome;
}



   public void setNome(String nome) {
	   this.nome = nome;
}



   public static long getSerialversionuid() {
	   return serialVersionUID;
}
   
   
   
}
   
