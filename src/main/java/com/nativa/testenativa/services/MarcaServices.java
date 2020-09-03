package com.nativa.testenativa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.repositories.MarcaRepository;
import com.nativa.testenativa.services.exceptions.ObjectNotFoundException;


@Service
public class MarcaServices {
	
	@Autowired
	private MarcaRepository repo;
	
	public Marca buscar(Integer marcaid) {
		Optional<Marca> obj = repo.findById(marcaid);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + marcaid
					+", Tipo: " + Marca.class.getName()));
		
	
	}
	
	public Marca insert(Marca obj) {
		obj.setMarcaId(null);
		return repo.save(obj);
		
	}

}
