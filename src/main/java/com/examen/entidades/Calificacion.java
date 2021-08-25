package com.examen.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "calificacion")
public class Calificacion {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 Long id;
	 
	 @ManyToOne
	 @JoinColumn(name="id_alumno", referencedColumnName = "id")
	 private Alumno alumno;
	 
	 @ManyToOne
	 @JoinColumn(name="id_materia", referencedColumnName = "id")
	 private Materias materia;
	 
	 
	 @Column(name = "calificacion")
	 private Integer calificacion;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public Materias getMateria() {
		return materia;
	}


	public void setMateria(Materias materia) {
		this.materia = materia;
	}


	public Integer getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	 
	 
	 
}
