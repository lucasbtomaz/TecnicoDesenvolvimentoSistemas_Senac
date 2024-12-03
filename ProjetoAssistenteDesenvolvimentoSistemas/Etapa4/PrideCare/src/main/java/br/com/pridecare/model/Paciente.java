package br.com.pridecare.model;

import java.util.Date;

public class Paciente {
    private int idPaciente;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private char genero;
    private String orientacaoSexual;

    // Getters e Setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    // Outros métodos de negócio podem ser adicionados conforme necessário
}
