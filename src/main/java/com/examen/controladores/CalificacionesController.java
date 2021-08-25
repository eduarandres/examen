package com.examen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.entidades.Respuesta;
import com.examen.entidadesDTO.CalificacionDTO;
import com.examen.servicios.CalificacionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value= "/calificacion")
@RestController
public class CalificacionesController {
	
	@Autowired
	CalificacionService calificacionService;
	
	@PostMapping("/registrar")
	public ResponseEntity<Respuesta> registrar(@RequestBody CalificacionDTO calificacion){
			
		return  calificacionService.registrar(calificacion);
	}
	
	@PostMapping("/editar")
	public ResponseEntity<Respuesta> editar(@RequestBody CalificacionDTO calificacion){		
		return  calificacionService.editar(calificacion);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Respuesta> eliminar(@RequestBody CalificacionDTO calificacion){		
		return  calificacionService.eliminar(calificacion);
	}
	
}
