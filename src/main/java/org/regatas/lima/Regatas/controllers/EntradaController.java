package org.regatas.lima.Regatas.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.regatas.lima.Regatas.entities.Entrada;
import org.regatas.lima.Regatas.services.EntradaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EntradaController {
	
	private static final Logger logger = LoggerFactory.getLogger(EntradaController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private EntradaService entradaService;
	
	@GetMapping("/entrada")
	public List<Entrada> productos() {
		logger.info("call asistencia");
		
		List<Entrada> entradas = entradaService.findAll();
		logger.info("entradas: " + entradas);
		
		return entradas;
	}

	@GetMapping("/entrada/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		logger.info("call images: " + filename);
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		logger.info("Path: " + path);
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
		logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}
	
	
	@PostMapping("/entrada")
	public Entrada crear(@RequestParam(name="imagen", required=false) MultipartFile imagen, @RequestParam("codigo_e") String codigo_e,
			@RequestParam("dni_e") String dni_e, @RequestParam("fecha_e") String fecha_e,
			@RequestParam("hora_e") String hora_e) throws Exception {
		logger.info("call crear(" + codigo_e + ", " + fecha_e + ", " + hora_e + ", " + dni_e + "," + imagen +")");
		
		Entrada entrada = new Entrada();
		entrada.setCodigo_e(codigo_e);
		entrada.setDni_e(dni_e);
		entrada.setFecha_e(fecha_e);
		entrada.setHora_e(hora_e);
		
		if (imagen != null && !imagen.isEmpty()) {
			String filename = System.currentTimeMillis() + imagen.getOriginalFilename().substring(imagen.getOriginalFilename().lastIndexOf("."));
			entrada.setImagen(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(imagen.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		entradaService.save(entrada);
		
		return entrada;
	}

	@GetMapping("/entrada/{dni_e}")
	public List<Entrada> obtener(@PathVariable String dni_e){
		logger.info("call obtener"+dni_e);
		
		List<Entrada> entrada =entradaService.findByName(dni_e);
		return entrada;
	}
}






