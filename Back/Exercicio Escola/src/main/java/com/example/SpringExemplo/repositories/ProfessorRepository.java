package com.example.SpringExemplo.repositories;

import com.example.SpringExemplo.entites.Aluno;
import com.example.SpringExemplo.entites.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
