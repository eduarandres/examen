package com.examen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidades.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

	List<Alumno> findByNombre(String nombre);

	Optional<Alumno> findByMatricula(String matricula);

}
