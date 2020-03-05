package org.regatas.lima.Regatas.controllers;

import java.util.List;

import org.regatas.lima.Regatas.entities.Registro;
import org.regatas.lima.Regatas.services.RegistroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroController {
	
	private static final Logger logger = LoggerFactory.getLogger(EntradaController.class);

	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private RegistroService registroService;
	
	@GetMapping("/registro")
	public List<Registro> registros(){
		logger.info("call registros");
		
		List<Registro> registros = registroService.findAll();
		logger.info("registros:"+ registros);
		
		return registros;
	}
}
