package com.nativa.testenativa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nativa.testenativa.domain.Usuarios;
import com.nativa.testenativa.repositories.UsuariosRepository;
import com.nativa.testenativa.security.UsersSS;

public class UserDetailsServices implements UserDetailsService {

	@Autowired
	private UsuariosRepository repo;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuarios user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UsersSS( user.getId(), user.getEmail(), user.getSenha());
	}

}
