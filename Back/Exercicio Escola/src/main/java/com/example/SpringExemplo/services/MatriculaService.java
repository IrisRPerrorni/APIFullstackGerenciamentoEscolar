package com.example.SpringExemplo.services;
import com.example.SpringExemplo.entites.Matricula;
import com.example.SpringExemplo.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> listarMatriculas(){
        return  matriculaRepository.findAll();
    }

    public Matricula listarMatriculaId(Long id){
        Optional<Matricula> obj=matriculaRepository.findById(id);
        return obj.get();
    }

    public Matricula inserirMatricula(Matricula obj){
        return   matriculaRepository.save(obj);
    }

    public void  deletarMatricula(Long id ){
        matriculaRepository.deleteById(id);
    }

}
