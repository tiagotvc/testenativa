package com.nativa.testenativa.resources;

import java.net.URI;
import java.util.ArrayList;
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

import com.nativa.testenativa.domain.Usuarios;
import com.nativa.testenativa.dto.UsuariosDTO;
import com.nativa.testenativa.repositories.UsuariosRepository;
import com.nativa.testenativa.resources.exception.FieldMessage;
import com.nativa.testenativa.services.UsuariosServices;


@RestController
@RequestMapping(value="/Usuarios")
public class UsuariosResources {
	
	@Autowired
	private UsuariosServices service;
	
	@Autowired
	private UsuariosRepository repo;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public  ResponseEntity<Usuarios> find(@PathVariable Integer id) {
		Usuarios obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuariosDTO objDto, @PathVariable Integer id){
		List<FieldMessage> list = new ArrayList<>();
        Usuarios aux = repo.findByEmail(objDto.getEmail());
        if(aux != null) {
        	list.add(new FieldMessage("Email", "Email já existe"));
        	}
		    Usuarios obj = service.fromDTO(objDto);
	        obj.setId(id);
	        obj = service.update(obj);
	        return ResponseEntity.noContent().build();
}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
	    service.deleteById(id);
	    return ResponseEntity.noContent().build();
	    
	
}
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<UsuariosDTO>> findAll() {
		List<Usuarios> list = service.findAll();
		List<UsuariosDTO> listDto = list.stream().map(obj -> new UsuariosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

	@RequestMapping(value ="/page" ,method=RequestMethod.GET)
	public  ResponseEntity<Page<UsuariosDTO>> findPage(
			@RequestParam(value ="page" , defaultValue="0")Integer page,
			@RequestParam(value ="linesPerPage" , defaultValue="24")Integer linesPerPage,
			@RequestParam(value ="orderBy" , defaultValue="nome")String orderBy,
			@RequestParam(value ="direction" , defaultValue="ASC")String direction) {
		Page<Usuarios> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UsuariosDTO> listDto = list.map(obj -> new UsuariosDTO(obj));
		return ResponseEntity.ok().body(listDto);
	
}
	
	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuariosDTO objDto){
		List<FieldMessage> list = new ArrayList<>();
        Usuarios aux = repo.findByEmail(objDto.getEmail());
        if(aux != null) {
        	list.add(new FieldMessage("Email", "Email já existe"));
        	}
            Usuarios obj = service.fromDTO(objDto);
		    obj = service.insert(obj);
		    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		    return ResponseEntity.created(uri).build();
}
	}
