package com.ibm.academia.apirest.ruletita.apuestaapirest.entities;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "apuestas",schema = "apuesta")
public class Apuesta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "color")
	private String color;
	@Column(name = "dinero")
	private double dinero;
	
	@OneToOne
	@JoinColumn(name = "id_ruleta")
	private Ruleta ruleta;
	
	public Apuesta() {
		
	}

	public Apuesta(Integer id, int numero, String color, double dinero, Ruleta ruleta) {
		super();
		this.id = id;
		this.numero = numero;
		this.color = color;
		this.dinero = dinero;
		this.ruleta = ruleta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public Ruleta getRuleta() {
		return ruleta;
	}

	public void setRuleta(Ruleta ruleta) {
		this.ruleta = ruleta;
	}
	
	
	
	

}
