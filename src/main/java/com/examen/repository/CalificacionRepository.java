package com.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examen.entidades.Calificacion;

@Repository
@Transactional
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

	@Query( value = "SELECT * FROM calificacion WHERE id_alumno = ?1", nativeQuery = true)
	List<Calificacion> findByIdAlumno(Long idAlumno);
	
	@Modifying
	@Query( value = "UPDATE calificacion SET calificacion = ?1 WHERE id_alumno = ?2 AND id_materia = ?3", nativeQuery = true)
	Integer  actulizarCalificacion(Integer calificacion,Long idAlumno, Long idMateria);
	
	@Modifying
	@Query( value = "UPDATE calificacion SET calificacion = null WHERE id_alumno = ?1 AND id_materia = ?2", nativeQuery = true)
	Integer  eliminarCalificacion(Long idAlumno, Long idMateria);
}
