package com.ibm.academia.apirest.ruletita.apuestaapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Apuesta;
import com.ibm.academia.apirest.ruletita.apuestaapirest.repositories.ApuestaRepository;

@Service
public class ApuestaServiceImpl implements ApuestaService{
	

	
	@Autowired
	private ApuestaRepository apuestaRepo;

	@Override
	public List<Apuesta> todasApuestas() {
		// TODO Auto-generated method stub
		return apuestaRepo.findAll();
	}

	@Override
	public void guardarApuesta(Apuesta apuesta) {
		apuestaRepo.save(apuesta);
		
	}

}
