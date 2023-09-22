package com.example.SpringExemplo.dto;

import com.example.SpringExemplo.entites.Matricula;

import java.io.Serializable;

public class MatriculaDTO implements Serializable {
    private static final long serialverionUID=1L;

    private String nome_curso,nome_aluno,email,dt_matricula;

    public MatriculaDTO() {
    }

    public MatriculaDTO(Matricula obj){
        dt_matricula=obj.getDt_matricula();
        nome_curso=obj.getCurso().getNome();
        nome_aluno=obj.getAluno().getNome();
        email=obj.getAluno().getEmail();
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDt_matricula() {
        return dt_matricula;
    }

    public void setDt_matricula(String dt_matricula) {
        this.dt_matricula = dt_matricula;
    }
}
