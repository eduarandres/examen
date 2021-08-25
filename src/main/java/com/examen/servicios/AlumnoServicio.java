package com.examen.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examen.entidades.Alumno;
import com.examen.entidades.Calificacion;
import com.examen.entidades.Materias;
import com.examen.entidades.Respuesta;
import com.examen.entidadesDTO.AlumnoDTO;
import com.examen.entidadesDTO.ConsultaCalificacionDTO;
import com.examen.entidadesDTO.ConsultaDTO;
import com.examen.entidadesDTO.MateriasDTO;
import com.examen.repository.AlumnoRepository;
import com.examen.repository.CalificacionRepository;
import com.examen.repository.MateriaRepository;

@Service
public class AlumnoServicio {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Autowired
	MateriaRepository materiaRepository;

	@Autowired
	CalificacionRepository calificacionRepository;

	public ResponseEntity<Respuesta> registrar(AlumnoDTO alumnoDTO) {
		Respuesta respuesta = new Respuesta();
		Alumno alumno = new Alumno();
		Optional<Materias> materia;
		Alumno AlumnoRespuesta = new Alumno();
		try {
			alumno.setApellidoMaterno(alumnoDTO.getApellidoMaterno());
			alumno.setApellidoPaterno(alumnoDTO.getApellidoPaterno());
			alumno.setNombre(alumnoDTO.getNombre());
			alumno.setMatricula(generarCadenaMay());
			AlumnoRespuesta = alumnoRepository.save(alumno);

			for (int i = 0; i < alumnoDTO.getMateria().length; i++) {
				Calificacion calificacion = new Calificacion();
				materia = materiaRepository.findById(alumnoDTO.getMateria()[i]);
				if (materia.isEmpty()) {
					respuesta.setCodigo(400);
					respuesta.setDatos("no existe materia con ese id");
					return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
				}

				calificacion.setAlumno(AlumnoRespuesta);
				calificacion.setMateria(materia.get());
				calificacionRepository.save(calificacion);

			}

			respuesta.setCodigo(200);
			respuesta.setDatos("Usuario Registrado Con Exito");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}

	}

	public ResponseEntity<Respuesta> consultar() {
		Respuesta respuesta = new Respuesta();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<ConsultaDTO> consultaLista = new ArrayList<ConsultaDTO>();
		try {
			alumnos = alumnoRepository.findAll();

			for (Alumno alumno : alumnos) {
				ConsultaDTO consulta = new ConsultaDTO();
				List<Calificacion> calificaciones = new ArrayList<Calificacion>();
				List<Materias> materias = new ArrayList<Materias>();

				calificaciones = calificacionRepository.findByIdAlumno(alumno.getId());
				for (Calificacion cMateria : calificaciones) {
					materias.add(cMateria.getMateria());
				}
				consulta.setAlumno(alumno);
				consulta.setMaterias(materias);

				consultaLista.add(consulta);
			}
			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	public ResponseEntity<Respuesta> consultarCalificacion() {
		Respuesta respuesta = new Respuesta();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<ConsultaCalificacionDTO> consultaLista = new ArrayList<ConsultaCalificacionDTO>();
		try {
			alumnos = alumnoRepository.findAll();

			for (Alumno alumno : alumnos) {
				ConsultaCalificacionDTO consulta = new ConsultaCalificacionDTO();
				List<Calificacion> calificaciones = new ArrayList<Calificacion>();
				List<MateriasDTO> materias = new ArrayList<MateriasDTO>();

				calificaciones = calificacionRepository.findByIdAlumno(alumno.getId());
				for (Calificacion cMateria : calificaciones) {
					MateriasDTO materiasCalificacion = new MateriasDTO();
					materiasCalificacion.setId(cMateria.getMateria().getId());
					materiasCalificacion.setNombre(cMateria.getMateria().getNombre());
					materiasCalificacion.setCalificacion(cMateria.getCalificacion());

					materias.add(materiasCalificacion);
				}
				consulta.setAlumno(alumno);
				consulta.setMaterias(materias);

				consultaLista.add(consulta);
			}
			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	public ResponseEntity<Respuesta> consultarCalificacionId(Long id) {
		Respuesta respuesta = new Respuesta();
		Alumno alumnos = new Alumno();
		List<ConsultaCalificacionDTO> consultaLista = new ArrayList<ConsultaCalificacionDTO>();
		try {
			alumnos = alumnoRepository.findById(id).get();

			ConsultaCalificacionDTO consulta = new ConsultaCalificacionDTO();
			List<Calificacion> calificaciones = new ArrayList<Calificacion>();
			List<MateriasDTO> materias = new ArrayList<MateriasDTO>();

			calificaciones = calificacionRepository.findByIdAlumno(alumnos.getId());
			for (Calificacion cMateria : calificaciones) {
				MateriasDTO materiasCalificacion = new MateriasDTO();
				materiasCalificacion.setId(cMateria.getMateria().getId());
				materiasCalificacion.setNombre(cMateria.getMateria().getNombre());
				materiasCalificacion.setCalificacion(cMateria.getCalificacion());

				materias.add(materiasCalificacion);
			}
			consulta.setAlumno(alumnos);
			consulta.setMaterias(materias);

			consultaLista.add(consulta);

			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	public ResponseEntity<Respuesta> consultarId(Long id) {
		Respuesta respuesta = new Respuesta();
		Alumno alumnos = new Alumno();
		List<ConsultaDTO> consultaLista = new ArrayList<ConsultaDTO>();
		try {
			alumnos = alumnoRepository.findById(id).get();

			ConsultaDTO consulta = new ConsultaDTO();
			List<Calificacion> calificaciones = new ArrayList<Calificacion>();
			List<Materias> materias = new ArrayList<Materias>();

			calificaciones = calificacionRepository.findByIdAlumno(alumnos.getId());
			for (Calificacion cMateria : calificaciones) {
				materias.add(cMateria.getMateria());
			}
			consulta.setAlumno(alumnos);
			consulta.setMaterias(materias);

			consultaLista.add(consulta);

			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	public ResponseEntity<Respuesta> consultarMatricula(String matricula) {
		Respuesta respuesta = new Respuesta();
		Alumno alumnos = new Alumno();
		List<ConsultaDTO> consultaLista = new ArrayList<ConsultaDTO>();
		try {
			alumnos = alumnoRepository.findByMatricula(matricula).get();

			ConsultaDTO consulta = new ConsultaDTO();
			List<Calificacion> calificaciones = new ArrayList<Calificacion>();
			List<Materias> materias = new ArrayList<Materias>();

			calificaciones = calificacionRepository.findByIdAlumno(alumnos.getId());
			for (Calificacion cMateria : calificaciones) {
				materias.add(cMateria.getMateria());
			}
			consulta.setAlumno(alumnos);
			consulta.setMaterias(materias);

			consultaLista.add(consulta);

			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	public ResponseEntity<Respuesta> consultarNombre(String nombre) {
		Respuesta respuesta = new Respuesta();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<ConsultaDTO> consultaLista = new ArrayList<ConsultaDTO>();
		try {
			alumnos = alumnoRepository.findByNombre(nombre);

			for (Alumno alumno : alumnos) {
				ConsultaDTO consulta = new ConsultaDTO();
				List<Calificacion> calificaciones = new ArrayList<Calificacion>();
				List<Materias> materias = new ArrayList<Materias>();

				calificaciones = calificacionRepository.findByIdAlumno(alumno.getId());
				for (Calificacion cMateria : calificaciones) {
					materias.add(cMateria.getMateria());
				}
				consulta.setAlumno(alumno);
				consulta.setMaterias(materias);

				consultaLista.add(consulta);
			}
			respuesta.setCodigo(200);
			respuesta.setDatos(consultaLista);
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			respuesta.setCodigo(200);
			respuesta.setDatos(e.getMessage());
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		}
	}

	private String generarCadenaMay() {
		String res = "";
		for (int cont = 1; cont <= 10; cont++) {
			int num = (int) ((Math.random() * (('Z' - 'A') + 1)) + 'A');
			char letra = (char) num;
			res = res + letra;
		}
		return res;
	}
}
