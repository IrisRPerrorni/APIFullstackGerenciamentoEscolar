package com.example.SpringExemplo.dto;
import com.example.SpringExemplo.entites.Aluno;
import java.io.Serializable;

public class AlunoDTO implements Serializable {
    private static final long serialverionUID=1L;
    private String nome,email;
    private String nome_curso;



    public AlunoDTO() {
    }

    public AlunoDTO(Aluno obj){
        nome=obj.getNome();
        email=obj.getEmail();
        nome_curso=obj.getCurso().getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }


}
