package org.regatas.lima.Regatas.services;

import java.util.List;
import org.regatas.lima.Regatas.entities.Razon;

public interface RazonService {
	
	public List<Razon> findAll();
	
	public Razon findById(Long id_ra);
	
	public void save(Razon razon);
	
	public void deleteById(Long id_ra);
	
	public List<Razon> findByName(String dni_ra);

}
