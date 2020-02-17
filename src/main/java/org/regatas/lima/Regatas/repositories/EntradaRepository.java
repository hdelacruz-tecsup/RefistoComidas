package org.regatas.lima.Regatas.repositories;

import java.util.List;

import org.regatas.lima.Regatas.entities.Entrada;
import org.springframework.data.repository.CrudRepository;

public interface EntradaRepository extends CrudRepository<Entrada, Long>  {
	
	@Override
	List<Entrada> findAll();

}
