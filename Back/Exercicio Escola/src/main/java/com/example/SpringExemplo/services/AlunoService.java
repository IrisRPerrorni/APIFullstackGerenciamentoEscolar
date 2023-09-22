package com.example.SpringExemplo.services;

import com.example.SpringExemplo.entites.Aluno;
import com.example.SpringExemplo.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos(){
        return  alunoRepository.findAll();
    }

    public Aluno listarAlunoId (Long id){
        Optional<Aluno> obj=alunoRepository.findById(id);
        return obj.get();
    }

    public Aluno inserirAluno(Aluno obj){
        return   alunoRepository.save(obj);
    }

    public void  deletarAluno(Long id ){
        alunoRepository.deleteById(id);
    }



}
