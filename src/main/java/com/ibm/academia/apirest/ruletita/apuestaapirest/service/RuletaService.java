package com.ibm.academia.apirest.ruletita.apuestaapirest.service;

import java.util.List;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Ruleta;

public interface RuletaService {
	
	List<Ruleta> todasRuletas();
	void guardarRuleta(Ruleta ruleta);
	String apostar(int numero, int dinero, int id);

}
