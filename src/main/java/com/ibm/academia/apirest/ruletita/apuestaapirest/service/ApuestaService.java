package com.ibm.academia.apirest.ruletita.apuestaapirest.service;

import java.util.List;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Apuesta;

public interface ApuestaService {
	
	List<Apuesta> todasApuestas();
	void guardarApuesta(Apuesta apuesta);

}
