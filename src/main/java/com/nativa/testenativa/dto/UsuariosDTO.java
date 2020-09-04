package com.nativa.testenativa.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nativa.testenativa.domain.Usuarios;

public class UsuariosDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
		
		private Integer id;
		
		@NotEmpty(message ="Preenchimento Obrigatório")
		@Length(min=5, message="O tamanho deve ter no minimo 5 caracteres")
		private String nome;
		
		@NotEmpty(message ="Preenchimento Obrigatório")
		@Email(message = "Email inválido")
		private String email;
		
		private String senha;
		


   public UsuariosDTO() {
   }
   
   public UsuariosDTO(Usuarios obj) {
	   id = obj.getId();
	   nome = obj.getNome();
	   email = obj.getEmail();
	   senha = obj.getSenha();
	  
   }
   

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
   
   
   }
