package org.regatas.lima.Regatas.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.regatas.lima.Regatas.entities.Razon;
import org.regatas.lima.Regatas.repositories.RazonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RazonServiceImpl implements RazonService {

	@Autowired
	private RazonRepository razonRepository;
	
	@Override
	public List<Razon> findAll() {
		return razonRepository.findAll();
	}

	@Override
	public Razon findById(Long id_ra) {
		return razonRepository.findById(id_ra).orElseThrow(() -> new EntityNotFoundException("No existe el registro"));
	}

	@Override
	public void save(Razon razon) {
		razonRepository.save(razon);
		
	}

	@Override
	public void deleteById(Long id_ra) {
		razonRepository.deleteById(id_ra);	
	}

	@Override
	public List<Razon> findByName(String dni_ra) {
		List<Razon>razones = razonRepository.findAll();
		List<Razon>lista = new ArrayList<>();
		for(Razon raz : razones){
			if(raz.getDni_ra().equals(dni_ra)){
				lista.add(raz);
			}
		}return lista;
	}

	
}
