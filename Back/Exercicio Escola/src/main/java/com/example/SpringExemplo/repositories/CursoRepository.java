package com.example.SpringExemplo.repositories;

import com.example.SpringExemplo.entites.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {

}
