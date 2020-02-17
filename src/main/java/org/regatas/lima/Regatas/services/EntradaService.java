package org.regatas.lima.Regatas.services;

import java.util.List;
import org.regatas.lima.Regatas.entities.Entrada;

public interface EntradaService {
	
	public List<Entrada> findAll();
	
	public Entrada findById(Long id_asist);
	
	public void save(Entrada entrada);
	
	public void deleteById(Long id_asist);

	public List<Entrada> findByName(String dni_e);

}
