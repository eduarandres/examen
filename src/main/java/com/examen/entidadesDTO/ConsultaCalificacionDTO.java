package com.examen.entidadesDTO;


import java.util.List;

import com.examen.entidades.Alumno;

import lombok.Data;

@Data
public class ConsultaCalificacionDTO {

	private Alumno alumno;
	private List<MateriasDTO> materias;
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<MateriasDTO> getMaterias() {
		return materias;
	}
	public void setMaterias(List<MateriasDTO> materias) {
		this.materias = materias;
	}
	

}
