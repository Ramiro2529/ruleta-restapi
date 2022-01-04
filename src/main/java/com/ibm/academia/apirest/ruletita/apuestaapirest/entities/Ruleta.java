package com.ibm.academia.apirest.ruletita.apuestaapirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruletas",schema = "apuesta")
public class Ruleta implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha_apertura")
	private Date fechaApertura;
	
	@Column(name = "fecha_cierre")
	private Date fechaCierre;
	
	@Column(name = "estado")
	private int estado;
	
	public Ruleta() {
		
	}

	public Ruleta(Integer id, Date fechaApertura, Date fechaCierre, int estado) {
		super();
		this.id = id;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ruleta other = (Ruleta) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return String.format("Ruleta [id=%s, fechaApertura=%s, fechaCierre=%s, estado=%s]", id, fechaApertura,
				fechaCierre, estado);
	}
	
	
	

}
