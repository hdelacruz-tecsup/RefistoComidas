package org.regatas.lima.Regatas.repositories;

import java.util.List;

import org.regatas.lima.Regatas.entities.Salida;
import org.springframework.data.repository.CrudRepository;

public interface SalidaRepository  extends CrudRepository<Salida, Long>{

	@Override
	List<Salida>findAll();
}
