package com.examen.entidadesDTO;


import lombok.Data;

@Data
public class AlumnoDTO {

	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Long[] materia;


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

	public Long[] getMateria() {
		return materia;
	}

	public void setMateria(Long[] materia) {
		this.materia = materia;
	}

	

	

}
