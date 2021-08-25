package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entidades.Materias;

@Repository
public interface MateriaRepository extends JpaRepository<Materias, Long> {

}
