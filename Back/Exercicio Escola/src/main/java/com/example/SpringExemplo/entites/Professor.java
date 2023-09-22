package com.example.SpringExemplo.entites;

import jakarta.persistence.*;
@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome,senha,email;
    private Integer idade;
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Professor() {
    }


    public Professor(Long id, String nome, Integer idade, Double salario, Curso curso,String email,String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.curso = curso;
        this.email = email;
        this.senha = senha;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }


    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
