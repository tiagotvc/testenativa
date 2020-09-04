package com.nativa.testenativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.dto.MarcaDTO;
import com.nativa.testenativa.repositories.MarcaRepository;
import com.nativa.testenativa.services.exceptions.DataIntegrityException;
import com.nativa.testenativa.services.exceptions.ObjectNotFoundException;




@Service
public class MarcaServices {
	
	@Autowired
	private MarcaRepository repo;
	
	public Marca find(Integer marcaid) {
		Optional<Marca> obj = repo.findById(marcaid);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + marcaid
					+", Tipo: " + Marca.class.getName()));
		
	
	}
	
	public Marca insert(Marca obj) {
		obj.setMarcaId(null);
		return repo.save(obj);
		
	}
	
	public Marca update(Marca obj) {
		find(obj.getMarcaId());
		return repo.save(obj);
	}
	
	public void deleteById(Integer marcaid) {
		find(marcaid);
		try {
		     repo.deleteById(marcaid);
	}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma Marca que está ligada a um Patrimonio");
		}

}
	public List<Marca> findAll(){
		return repo.findAll();
	}
	
	public Page<Marca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
       PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
	   return repo.findAll(pageRequest);
	}
	
	public Marca fromDTO(MarcaDTO objDto) {
		return new Marca(objDto.getMarcaid(), objDto.getNome());
	}
}

