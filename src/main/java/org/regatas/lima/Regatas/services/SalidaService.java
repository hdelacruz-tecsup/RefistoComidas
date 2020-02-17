package org.regatas.lima.Regatas.services;

import java.util.List;

import org.regatas.lima.Regatas.entities.Salida;

public interface SalidaService {
	
	public List<Salida> findAll();
	
	public Salida findById(Long idsal);
	
	public void save(Salida salida);
	
	public void deleteById(Long idsal);

}
