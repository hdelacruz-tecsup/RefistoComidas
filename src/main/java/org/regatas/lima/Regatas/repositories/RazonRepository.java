package org.regatas.lima.Regatas.repositories;

import java.util.List;

import org.regatas.lima.Regatas.entities.Razon;
import org.springframework.data.repository.CrudRepository;

public interface RazonRepository  extends CrudRepository<Razon, Long>  {
	
	@Override
	List<Razon> findAll();

}
