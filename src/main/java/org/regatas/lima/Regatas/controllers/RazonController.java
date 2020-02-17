package org.regatas.lima.Regatas.controllers;

import java.util.List;

import org.regatas.lima.Regatas.entities.Razon;
import org.regatas.lima.Regatas.services.RazonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazonController {

	private static final Logger logger = LoggerFactory.getLogger(RazonController.class);

	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private RazonService razonService;
	
	@GetMapping("/razon")
	public List<Razon>razones() {
		logger.info("call razones");
		
		List<Razon> razones = razonService.findAll();
		logger.info("razon: " + razones);
		
		return razones;
	}
	
	@PostMapping("/razon")
	public Razon crear(@RequestParam("dni_ra") String dni_ra, @RequestParam("razon_ra") String razon_ra,
			@RequestParam("fecha_ini") String fecha_ini,@RequestParam("fecha_fin") String fecha_fin) throws Exception {
		logger.info("call crear(" + dni_ra + ", " + razon_ra + ", " + fecha_ini + ", " + fecha_fin + ")");
		
		Razon razon = new Razon();
		razon.setDni_ra(dni_ra);
		razon.setRazon_ra(razon_ra);
		razon.setFecha_ini(fecha_ini);
		razon.setFecha_fin(fecha_fin);
		
		razonService.save(razon);
		
		return razon;
	}

	@DeleteMapping("/razon/{id_ra}")
	public ResponseEntity<String> eliminar(@PathVariable Long id_ra) {
		logger.info("call eliminar: " + id_ra);
		
		razonService.deleteById(id_ra);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}

	@GetMapping("/razonid/{id_ra}")
	public Razon obtener(@PathVariable Long id_ra) {
		logger.info("call obtener: " + id_ra);
		
		Razon razon = razonService.findById(id_ra);
		
		return razon;
	}
	
	@GetMapping("/razondni/{dni_ra}")
	public List<Razon> obtener(@PathVariable String dni_ra){
		logger.info("call obtener"+dni_ra);
		
		List<Razon> razon = razonService.findByName(dni_ra);
		return razon;
	}


	
}
