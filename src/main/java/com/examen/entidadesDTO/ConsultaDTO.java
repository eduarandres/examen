package com.examen.entidadesDTO;


import java.util.List;

import com.examen.entidades.Alumno;
import com.examen.entidades.Materias;

import lombok.Data;

@Data
public class ConsultaDTO {

	private Alumno alumno;
	private List<Materias> materias;
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	

}
