package org.regatas.lima.Regatas.services;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.regatas.lima.Regatas.entities.Registro;
import org.regatas.lima.Regatas.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegistroServiceImple implements RegistroService{

	@Autowired
	private RegistroRepository registrorepository;
	
	@Override
	public List<Registro> findAll() {
		return registrorepository.findAll();
	}

	@Override
	public Registro findById(Long id_registro) {
		return registrorepository.findById(id_registro).orElseThrow(() -> new EntityNotFoundException("No existe el registro"));
	}

	@Override
	public void save(Registro registro) {
		registrorepository.save(registro);
		
	}

	@Override
	public void deleteById(Long id_registro) {
		registrorepository.deleteById(id_registro);
		
	}

	@Override
	public List<Registro> findByName(String dni_registro) {
		List<Registro>registros = registrorepository.findAll();
		List<Registro>lista = new ArrayList<>();
		for(Registro ent : registros){
			if(ent.getDni_registro().equals(dni_registro)) {
				lista.add(ent);
			}
		}return lista;
		
	}





}
