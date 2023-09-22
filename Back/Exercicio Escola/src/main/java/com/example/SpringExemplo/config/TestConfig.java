package com.example.SpringExemplo.config;
import com.example.SpringExemplo.entites.Aluno;
import com.example.SpringExemplo.entites.Curso;
import com.example.SpringExemplo.entites.Matricula;
import com.example.SpringExemplo.entites.Professor;
import com.example.SpringExemplo.repositories.AlunoRepository;
import com.example.SpringExemplo.repositories.CursoRepository;
import com.example.SpringExemplo.repositories.MatriculaRepository;
import com.example.SpringExemplo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public void run(String...args) throws Exception{

        Curso curso1 = new Curso(null,"Tecnologia da Informação",200);
        Curso curso2 = new Curso(null,"Medicina",800);
        cursoRepository.saveAll(Arrays.asList(curso1,curso2));

        Aluno aluno1 = new Aluno(null,"Muryllo Soares",23,"muryllo@gmail.com",curso1,"123456");
        Aluno aluno2 = new Aluno(null,"João Lobato",23,"joao@gmail.com",curso2,"123456");
        alunoRepository.saveAll(Arrays.asList(aluno1,aluno2));

        Professor professor1 = new Professor(null,"Marcio",50,3500.00,curso1,"marcio@gmail.com","123456");
        Professor professor2 = new Professor(null,"Silvio",30,2500.00,curso2,"silvio@gmail.com","123456");
        professorRepository.saveAll(Arrays.asList(professor1,professor2));

        Matricula matricula1= new Matricula(null,"27/06/2018",aluno1,curso1);
        Matricula matricula2= new Matricula(null,"15/09/2020",aluno2,curso2);
        matriculaRepository.saveAll(Arrays.asList(matricula1,matricula2));

    }

}
