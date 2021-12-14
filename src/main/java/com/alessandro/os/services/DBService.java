package com.alessandro.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alessandro.os.domain.Cliente;
import com.alessandro.os.domain.OS;
import com.alessandro.os.domain.Tecnico;
import com.alessandro.os.domain.enums.Prioridade;
import com.alessandro.os.domain.enums.Status;
import com.alessandro.os.repositories.ClienteRepository;
import com.alessandro.os.repositories.OSRepository;
import com.alessandro.os.repositories.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository oSRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Alessandro", "601.464.610-88", "3343-0277");
		Tecnico t2 = new Tecnico(null, "Erilene", "601.464.610-88", "3343-0277");
		Cliente c1 = new Cliente(null, "Erilene Troll", "601.464.610-88", "(88)93343-0000");
		OS os1 = new OS(null, Prioridade.ALTA, "obs", Status.Aberto, t1, c1);

		t1.getList().add(os1);
		t2.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		tecnicoRepository.saveAll(Arrays.asList(t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		oSRepository.saveAll(Arrays.asList(os1));

	}
}
