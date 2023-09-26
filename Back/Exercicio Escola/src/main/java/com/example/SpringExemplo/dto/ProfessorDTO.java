package com.example.SpringExemplo.dto;
import com.example.SpringExemplo.entites.Professor;

import java.io.Serializable;

public class ProfessorDTO implements Serializable {
    private static final long serialverionUID=1L;

    private String nome;
    private String nome_curso;
    private String email;
    public ProfessorDTO() {
    }

    public ProfessorDTO(Professor obj){
        nome=obj.getNome();
        nome_curso = obj.getCurso().getNome();
        email=obj.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
