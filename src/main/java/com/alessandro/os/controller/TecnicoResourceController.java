
package com.alessandro.os.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alessandro.os.DTO.TecnicoDTO;
import com.alessandro.os.domain.Tecnico;
import com.alessandro.os.services.TecnicoService;

@RestController
//End point = ponto extremo de comunicaçao ponto onde front and se comunica com back and
@RequestMapping(value = "/tecnicos")
public class TecnicoResourceController {
	@Autowired
	private TecnicoService tecnicoService;
	
	@GetMapping(value = "/{id}")
	
	public ResponseEntity<TecnicoDTO> findByID(@PathVariable Integer id){
		Tecnico obj = tecnicoService.findByID(id);
		TecnicoDTO objDTO = new TecnicoDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		List<Tecnico> list = tecnicoService.finAll();
		List<TecnicoDTO> listdto = new ArrayList<>();
		
		for(Tecnico obj : list) {
			listdto.add(new TecnicoDTO(obj));
		}
		return ResponseEntity.ok().body(listdto);
	}
	
	@PostMapping
	public ResponseEntity<TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
		Tecnico newObj = tecnicoService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

















