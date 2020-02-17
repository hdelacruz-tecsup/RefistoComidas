package org.regatas.lima.Regatas.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.regatas.lima.Regatas.entities.Salida;
import org.regatas.lima.Regatas.repositories.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SalidaServiceImpl implements SalidaService {

	@Autowired
	private  SalidaRepository salidaRepository;
	
	@Override
	public List<Salida> findAll() {
		return salidaRepository.findAll();
	}

	@Override
	public Salida findById(Long idsal) {
		return salidaRepository.findById(idsal).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Salida salida) {
		salidaRepository.save(salida);

	}

	@Override
	public void deleteById(Long idsal) {
		salidaRepository.deleteById(idsal);

	}

}
