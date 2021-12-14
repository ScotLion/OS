package com.alessandro.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alessandro.os.domain.Tecnico;
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
	
	@Query("Select obj from Tecnico obj where obj.cpf =:cpf")
	Tecnico findByCPF(@Param("cpf") String cpf);
	
	
}
