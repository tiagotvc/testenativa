package com.nativa.testenativa.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.services.MarcaServices;


@RestController
@RequestMapping(value="/Marcas")
public class MarcaResources {
	
	@Autowired
	private MarcaServices service;
	
	@RequestMapping(value="/{marcaid}",method=RequestMethod.GET)
	public  ResponseEntity<?> find(@PathVariable Integer marcaid) {
		
		Marca obj = service.buscar(marcaid);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Marca obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{marcaid}").buildAndExpand(obj.getMarcaId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	

}
