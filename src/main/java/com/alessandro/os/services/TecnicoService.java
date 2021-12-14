package com.alessandro.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.os.DTO.TecnicoDTO;
import com.alessandro.os.domain.Tecnico;
import com.alessandro.os.repositories.TecnicoRepository;
import com.alessandro.os.services.exception.DataIntegrityViolationExeption;
import com.alessandro.os.services.exception.ObjectNotFoundExeption;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository tecnicoRepository;

	public Tecnico findByID(Integer id) {

		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Objeto nao Encontrado ID: " + id + "Tipo: " + Tecnico.class.getName()));
	}

	public List<Tecnico> finAll() {
		return tecnicoRepository.findAll();

	}

	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataIntegrityViolationExeption("CPF Duplicado");
		}
		Tecnico newObj = new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
		return tecnicoRepository.save(newObj);
	}
	
	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = tecnicoRepository.findByCPF(objDTO.getCpf()); 
		if(obj != null) {
			return obj;
		}
		return null;
	}

}
