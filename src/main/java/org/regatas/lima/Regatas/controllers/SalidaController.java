package org.regatas.lima.Regatas.controllers;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.regatas.lima.Regatas.entities.Salida;
import org.regatas.lima.Regatas.services.SalidaService;
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
public class SalidaController {

	private static final Logger logger = LoggerFactory.getLogger(SalidaController.class);
	
	@Value("$app.storage.path")
	private String STORAGEPATH;
	
	@Autowired
	private SalidaService salidaService;
	
	@GetMapping("/salida")
	public List<Salida> salidas() {
		logger.info("call salidas");
		
		List<Salida> salidas = salidaService.findAll();
		logger.info("salidas: " + salidas);
		
		return salidas;
	}
	
	@GetMapping("/salida/images/{filename:.+}")
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
	
	//Metodo para el regsitro de datos
	
	@PostMapping("/salida")
	public Salida crear(@RequestParam(name="imagen", required=false) MultipartFile imagen, @RequestParam("codigo_s") String codigo_s,
			@RequestParam("dni_s") String dni_s, @RequestParam("fecha_s") String fecha_s,
			@RequestParam("hora_s") String hora_s,
			@RequestParam("razon_s") String razon_s) throws Exception {
		logger.info("call crear(" + codigo_s + ", " + dni_s + ", " + fecha_s + ", " + hora_s + ", " + razon_s + "," + imagen +")");
		
		Salida salida = new Salida();
		salida.setCodigo_s(codigo_s);
		salida.setDni_s(dni_s);
		salida.setFecha_s(fecha_s);
		salida.setHora_s(hora_s);
		salida.setRazon_s(razon_s);
		
		if (imagen != null && !imagen.isEmpty()) {
			String filename = System.currentTimeMillis() + imagen.getOriginalFilename().substring(imagen.getOriginalFilename().lastIndexOf("."));
			salida.setImagen(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(imagen.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		salidaService.save(salida);
		
		return salida;
	}	
}
























