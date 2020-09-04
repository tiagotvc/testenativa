package com.nativa.testenativa.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nativa.testenativa.domain.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios ,Integer> {
	
	@Transactional(readOnly=true)
	Usuarios findByEmail(String email);

	

}
