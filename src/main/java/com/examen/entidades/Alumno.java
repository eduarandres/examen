package com.examen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	 
	 
	 @Column(name = "matricula")
	 private String matricula;
	 
	 @Column(name = "nombre")
	 private String nombre;
	 
	 @Column(name = "apellido_paterno")
	 private String apellidoPaterno;
	 
	 @Column(name = "apellido_materno")
	 private String apellidoMaterno;
	 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	 
	 
}
