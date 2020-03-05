package org.regatas.lima.Regatas.repositories;

import java.util.List;

import org.regatas.lima.Regatas.entities.Registro;
import org.springframework.data.repository.CrudRepository;

public interface RegistroRepository extends CrudRepository<Registro, Long> {
	@Override
	List<Registro>findAll();

}
