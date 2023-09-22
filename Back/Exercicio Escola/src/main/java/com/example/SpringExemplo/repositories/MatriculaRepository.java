package com.example.SpringExemplo.repositories;

import com.example.SpringExemplo.entites.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {
}
