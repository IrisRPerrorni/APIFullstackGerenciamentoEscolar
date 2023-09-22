package com.example.SpringExemplo.dto;

import com.example.SpringExemplo.entites.Curso;

import java.io.Serializable;

public class CursoDTO implements Serializable {
    private static final long serialverionUID=1L;

    private String nome;
    public CursoDTO() {
    }

    public CursoDTO(Curso obj){
        nome=obj.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
