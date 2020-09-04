package com.nativa.testenativa.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.dto.MarcaDTO;
import com.nativa.testenativa.services.MarcaServices;


@RestController
@RequestMapping(value="/Marcas")
public class MarcaResources {
	
	@Autowired
	private MarcaServices service;
	
	@RequestMapping(value="/{marcaid}",method=RequestMethod.GET)
	public  ResponseEntity<Marca> find(@PathVariable Integer marcaid) {
		Marca obj = service.find(marcaid);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MarcaDTO objDto){
		Marca obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{marcaid}").buildAndExpand(obj.getMarcaId()).toUri();
		return ResponseEntity.created(uri).build();
		
}
	
	@RequestMapping(value="/{marcaid}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MarcaDTO objDto, @PathVariable Integer marcaid){
		Marca obj = service.fromDTO(objDto);
	    obj.setMarcaId(marcaid);
	    obj = service.update(obj);
	    return ResponseEntity.noContent().build();
}
	
	@RequestMapping(value="/{marcaid}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer marcaid){
	    service.deleteById(marcaid);
	    return ResponseEntity.noContent().build();
	    
	
}
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<MarcaDTO>> findAll() {
		List<Marca> list = service.findAll();
		List<MarcaDTO> listDto = list.stream().map(obj -> new MarcaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

	@RequestMapping(value ="/page" ,method=RequestMethod.GET)
	public  ResponseEntity<Page<MarcaDTO>> findPage(
			@RequestParam(value ="page" , defaultValue="0")Integer page,
			@RequestParam(value ="linesPerPage" , defaultValue="24")Integer linesPerPage,
			@RequestParam(value ="orderBy" , defaultValue="nome")String orderBy,
			@RequestParam(value ="direction" , defaultValue="ASC")String direction) {
		Page<Marca> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MarcaDTO> listDto = list.map(obj -> new MarcaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	
	
	
}
}
