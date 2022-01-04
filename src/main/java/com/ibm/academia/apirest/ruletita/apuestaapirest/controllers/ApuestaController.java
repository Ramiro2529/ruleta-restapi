package com.ibm.academia.apirest.ruletita.apuestaapirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Apuesta;
import com.ibm.academia.apirest.ruletita.apuestaapirest.service.ApuestaService;

@RestController
@RequestMapping("/apuesta")
public class ApuestaController {
	
	@Autowired
	private ApuestaService apuestaService;
	
	@GetMapping("/apuesta")
	public List<Apuesta> todasAPuestas(){
		
		return apuestaService.todasApuestas();
	}

}
