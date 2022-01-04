package com.ibm.academia.apirest.ruletita.apuestaapirest.controllers;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Ruleta;
import com.ibm.academia.apirest.ruletita.apuestaapirest.repositories.ApuestaRepository;
import com.ibm.academia.apirest.ruletita.apuestaapirest.repositories.RuletaRepository;
import com.ibm.academia.apirest.ruletita.apuestaapirest.service.RuletaService;

@RestController
@RequestMapping("/ruleta")
public class RuletaController {

	
	@Autowired
	private RuletaService ruletaService;
	
	@Autowired
	private RuletaRepository ruletaRepository;
	
	@Autowired
	private ApuestaRepository apuestaRepo;
	
	@PostMapping("/crear")
	public Integer crearRuleta() {
		
		Ruleta ruleta = new Ruleta();
		ruleta.setEstado(0);
		ruletaService.guardarRuleta(ruleta);
		
		return ruleta.getId();
	}
	
	
	@PutMapping("/ruleta/abrir/{id}")
	public String modificar(@PathVariable Integer id) {
		try {
		Ruleta ruleta = new Ruleta();
		ruleta.setId(id);
		ruleta.setFechaApertura(new Date());
		ruleta.setEstado(1);
		ruletaService.guardarRuleta(ruleta);
		
		return "La apuesta se abrió exitosamente";
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "La apuesta no se abrió";
	}
	
	@PostMapping("/ruleta/apuesta/{numero}/{dinero}/{id}")
	public String apuesta(@PathVariable int numero, @PathVariable int dinero, @PathVariable int id) {
		
		return ruletaService.apostar(numero, dinero, id);
	}
	
	@GetMapping("/ruleta/listar")
	public List<Ruleta> encontrarTodasRuletas(){
	
		return ruletaService.todasRuletas();
	}
}
