package com.examen.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examen.entidades.Respuesta;
import com.examen.entidadesDTO.CalificacionDTO;
import com.examen.repository.CalificacionRepository;

@Service
public class CalificacionService {

	@Autowired
	CalificacionRepository calificacionRepository;

	public ResponseEntity<Respuesta> registrar(CalificacionDTO calificacion) {
		Respuesta respuesta = new Respuesta();
		Integer respuestaConsulta;
		try {
			respuestaConsulta = calificacionRepository.actulizarCalificacion(calificacion.getCalificacion(), calificacion.getIdAlumno(),
					calificacion.getIdMateria());
			if (respuestaConsulta == 1) {
				respuesta.setCodigo(200);
				respuesta.setDatos("Calificacion Registrada");
				return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			}
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Registrada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Registrada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}

	}
	
	public ResponseEntity<Respuesta> editar(CalificacionDTO calificacion) {
		Respuesta respuesta = new Respuesta();
		Integer respuestaConsulta;
		try {
			respuestaConsulta = calificacionRepository.actulizarCalificacion(calificacion.getCalificacion(), calificacion.getIdAlumno(),
					calificacion.getIdMateria());
			if (respuestaConsulta == 1) {
				respuesta.setCodigo(200);
				respuesta.setDatos("Calificacion Editada");
				return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			}
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Editada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Editada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}

	}
	
	public ResponseEntity<Respuesta> eliminar(CalificacionDTO calificacion) {
		Respuesta respuesta = new Respuesta();
		Integer respuestaConsulta;
		try {
			respuestaConsulta = calificacionRepository.eliminarCalificacion( calificacion.getIdAlumno(),
					calificacion.getIdMateria());
			if (respuestaConsulta == 1) {
				respuesta.setCodigo(200);
				respuesta.setDatos("Calificacion Eliminada");
				return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			}
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Eliminada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			respuesta.setCodigo(400);
			respuesta.setDatos("Calificacion NO Eliminada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}

	}
}
