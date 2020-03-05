package org.regatas.lima.Regatas.services;

import java.util.List;

import org.regatas.lima.Regatas.entities.Registro;

public interface RegistroService {
	
	public List<Registro> findAll();
	
	public Registro findById(Long id_registro);
	
	public void save(Registro registro);
	
	public void deleteById(Long id_registro);

	public List<Registro> findByName(String dni_registro);

}
