package com.ibm.academia.apirest.ruletita.apuestaapirest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Apuesta;
import com.ibm.academia.apirest.ruletita.apuestaapirest.entities.Ruleta;
import com.ibm.academia.apirest.ruletita.apuestaapirest.repositories.RuletaRepository;

@Service
public class RuletaServiceImpl implements RuletaService {
	
	@Autowired
	private RuletaRepository ruletaRepo;
	
	@Autowired
	private ApuestaService apuestaService;

	@Override
	public List<Ruleta> todasRuletas() {
		
		return ruletaRepo.findAll();
	}

	@Override
	public void guardarRuleta(Ruleta ruleta) {
		ruletaRepo.save(ruleta);
		
	}

	@Override
	public String apostar(int numero, int dinero, int id) {
		double aux=0;
		Apuesta apuesta = new Apuesta();
		Ruleta ruleta = new Ruleta();
		ruleta.setId(id);
		Optional<Ruleta>list=ruletaRepo.findById(id);
			if (list.isPresent() && list.get().getEstado()==1) {
				List<Apuesta> lista = apuestaService.todasApuestas();
				for (Apuesta a : lista) {
					if (a.getRuleta().getId()== id) {
						aux = a.getDinero()+aux;
						
					}
				}
				if (aux<10000) {
					apuesta.setNumero(numero);
					apuesta.setDinero(dinero);
					apuesta.setRuleta(ruleta);
					apuestaService.guardarApuesta(apuesta);
					return "Apuesta recibida";
				}else {
					try {
						Ruleta r= new Ruleta();
						r.setId(id);
						r.setFechaApertura(null);
						r.setFechaCierre(null);
						r.setEstado(0);
						ruletaRepo.save(r);
						return " close Roulette";
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			return "Algo salió mal";
	}

}
