package com.example.SpringExemplo.services;
import com.example.SpringExemplo.entites.Curso;
import com.example.SpringExemplo.repositories.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos(){
        return  cursoRepository.findAll();
    }

    public Curso listarCursoId (Long id){
        Optional<Curso> obj=cursoRepository.findById(id);
        return obj.get();
    }

    public Curso inserirCurso(Curso obj){
        return   cursoRepository.save(obj);
    }

    public void  deletarCurso(Long id ){
        cursoRepository.deleteById(id);
    }

    public Curso atualizarCurso(Long id,Curso obj){
            Curso user = cursoRepository.getReferenceById(id);
            atualizarDados(user,obj);
            return cursoRepository.save(user);
    }

    private void atualizarDados(Curso curso, Curso obj) {
        curso.setNome(obj.getNome());
        curso.setCarga_horaria(obj.getCarga_horaria());
    }

}
