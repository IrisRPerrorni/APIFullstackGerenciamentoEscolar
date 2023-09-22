package com.example.SpringExemplo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {
    private static final long serialverionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dt_matricula;

    @JsonIgnore
    @OneToOne
    private Aluno aluno;

    @JsonIgnore
    @OneToOne
    private Curso curso;

    public Matricula() {
    }

    public Matricula(Long id, String dt_matricula,Aluno aluno,Curso curso) {
        this.id = id;
        this.dt_matricula = dt_matricula;
        this.aluno=aluno;
        this.curso=curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDt_matricula() {
        return dt_matricula;
    }

    public void setDt_matricula(String dt_matricula) {
        this.dt_matricula = dt_matricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
