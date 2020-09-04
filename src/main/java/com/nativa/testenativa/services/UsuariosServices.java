package com.nativa.testenativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nativa.testenativa.domain.Usuarios;
import com.nativa.testenativa.dto.UsuariosDTO;
import com.nativa.testenativa.repositories.UsuariosRepository;
import com.nativa.testenativa.services.exceptions.DataIntegrityException;
import com.nativa.testenativa.services.exceptions.ObjectNotFoundException;


@Service
public class UsuariosServices {
	
	@Autowired
	private UsuariosRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuarios find(Integer id) {
		Optional<Usuarios> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + id
					+", Tipo: " + Usuarios.class.getName()));
		
	
	}
	
	public Usuarios insert(Usuarios obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Usuarios update(Usuarios obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Integer id) {
		find(id);
		try {
		     repo.deleteById(id);
	}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma Usuarios que está ligada a um Patrimonio");
		}

}
	public List<Usuarios> findAll(){
		return repo.findAll();
	}
	
	public Page<Usuarios> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
       PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
	   return repo.findAll(pageRequest);
	}
	
	public Usuarios fromDTO(UsuariosDTO objDto) {
		return new Usuarios(objDto.getId(),objDto.getNome(),objDto.getEmail(),objDto.getSenha());
	}
}




