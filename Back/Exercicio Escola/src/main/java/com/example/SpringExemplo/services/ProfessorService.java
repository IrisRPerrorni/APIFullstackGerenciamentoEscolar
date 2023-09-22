package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.Curso;
import com.example.SpringExemplo.entites.Professor;
import com.example.SpringExemplo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessores(){
        return  professorRepository.findAll();
    }

    public Professor listarProfessorId (Long id){
        Optional<Professor> obj=professorRepository.findById(id);
        return obj.get();
    }

    public Professor inserirProfessor(Professor obj){
        return   professorRepository.save(obj);
    }

    public void  deletarProfessor(Long id ){
        professorRepository.deleteById(id);
    }

}
