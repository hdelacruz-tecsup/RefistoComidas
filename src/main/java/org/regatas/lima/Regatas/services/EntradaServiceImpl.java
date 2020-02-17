package org.regatas.lima.Regatas.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.regatas.lima.Regatas.entities.Entrada;
import org.regatas.lima.Regatas.repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EntradaServiceImpl implements EntradaService{

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Override
	public List<Entrada> findAll() {
		return entradaRepository.findAll();
	}

	@Override
	public Entrada findById(Long id_asist) {
		return entradaRepository.findById(id_asist).orElseThrow(() -> new EntityNotFoundException("No existe el registro"));
	}

	@Override
	public void save(Entrada entrada) {
		entradaRepository.save(entrada);
		
	}

	@Override
	public void deleteById(Long id_asist) {
		entradaRepository.deleteById(id_asist);
		
	}

	@Override
	public List<Entrada> findByName(String dni_e) {
		List<Entrada>entradas = entradaRepository.findAll();
		List<Entrada>lista = new ArrayList<>();
		for(Entrada ent : entradas){
			if(ent.getDni_e().equals(dni_e)) {
				lista.add(ent);
			}
		}return lista;
	}

	 	

}
