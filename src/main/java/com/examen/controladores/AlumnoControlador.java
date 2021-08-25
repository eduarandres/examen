package com.examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examen.entidades.Respuesta;
import com.examen.entidadesDTO.AlumnoDTO;
import com.examen.servicios.AlumnoServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value= "/alumnos")
@RestController
public class AlumnoControlador {
	
	@Autowired
	AlumnoServicio alumnoServicio;
	
	@GetMapping("/consultar")
    public ResponseEntity<Respuesta> consultar() {
		return  alumnoServicio.consultar();
    }
	
	@GetMapping("/consultar/calificacion")
    public ResponseEntity<Respuesta> consultarCalificacion() {
		return  alumnoServicio.consultarCalificacion();
    }
	
	@GetMapping("/consultar/calificacion/id/{id}")
    public ResponseEntity<Respuesta> consultarCalificacionId(@PathVariable("id")Long id) {
		return  alumnoServicio.consultarCalificacionId(id);
    }
	
	@GetMapping("/consultar/id/{id}")
    public ResponseEntity<Respuesta> consultarId(@PathVariable("id")Long id) {
		return  alumnoServicio.consultarId(id);
    }
	
	@GetMapping("/consultar/matricula/{matricula}")
    public ResponseEntity<Respuesta> consultarMatricula(@PathVariable("matricula")String id) {
		return  alumnoServicio.consultarMatricula(id);
    }
	
	@GetMapping("/consultar/nombre/{nombre}")
    public ResponseEntity<Respuesta> consultarNombre(@PathVariable("nombre")String id) {
		return  alumnoServicio.consultarNombre(id);
    }
	
	@PostMapping("/registrar")
	public ResponseEntity<Respuesta> registrar(@RequestBody AlumnoDTO alumno){
			
		return  alumnoServicio.registrar(alumno);
	}
}
