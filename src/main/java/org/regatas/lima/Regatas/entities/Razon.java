package org.regatas.lima.Regatas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "razon")
public class Razon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ra; 
	
	private String dni_ra;
	
	private String razon_ra;
	
	private String fecha_ini;
	
	private String fecha_fin;

	public Long getId_ra() {
		return id_ra;
	}

	public String getDni_ra() {
		return dni_ra;
	}

	public String getRazon_ra() {
		return razon_ra;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setId_ra(Long id_ra) {
		this.id_ra = id_ra;
	}

	public void setDni_ra(String dni_ra) {
		this.dni_ra = dni_ra;
	}

	public void setRazon_ra(String razon_ra) {
		this.razon_ra = razon_ra;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	@Override
	public String toString() {
		return "Razon [id_ra=" + id_ra + ", dni_ra=" + dni_ra + ", razon_ra=" + razon_ra + ", fecha_ini=" + fecha_ini
				+ ", fecha_fin=" + fecha_fin + "]";
	}
}
