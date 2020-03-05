package org.regatas.lima.Regatas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registro")
public class Registro {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id_registro;
	
	private String dni_registro;
	
	private String nombres;
	
	private String apellidos;

	public Long getId_registro() {
		return id_registro;
	}

	public String getDni_registro() {
		return dni_registro;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setId_registro(Long id_registro) {
		this.id_registro = id_registro;
	}

	public void setDni_registro(String dni_registro) {
		this.dni_registro = dni_registro;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Registro [id_registro=" + id_registro + ", dni_registro=" + dni_registro + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + "]";
	}



	
	
}
