package com.example.SpringExemplo.entites;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {
    private static final long serialverionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int carga_horaria;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Professor> professor= new ArrayList<>();

    @OneToOne(mappedBy = "curso",cascade = CascadeType.ALL)
    private Matricula matricula;


    public Curso() {
    }

    public Curso(Long id, String nome, int carga_horaria) {
        this.id = id;
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    public List<Professor> getProfessor() {
        return professor;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
