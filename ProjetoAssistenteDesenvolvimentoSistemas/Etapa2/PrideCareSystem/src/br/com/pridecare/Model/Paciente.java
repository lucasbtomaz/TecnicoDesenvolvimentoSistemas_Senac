/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

import java.util.Date;

/**
 *
 *  oluca
 */
public class Paciente {
    private int idPaciente;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private char genero;
    private String orientacaoSexual;
    private Prontuario prontuario;

    public Paciente(int idPaciente, String nome, String sobrenome, Date dataNascimento, char genero, String orientacaoSexual) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.orientacaoSexual = orientacaoSexual;
    }

    // Métodos getters
    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public char getGenero() {
        return genero;
    }

    public String getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    // Métodos específicos para pacientes
    public void consultarInformacoes() {
        System.out.println("Consultando informações de paciente: " + this.nome + " " + this.sobrenome);
    }

    public void marcarConsulta() {
        System.out.println("Paciente " + this.nome + " " + this.sobrenome + " marcou uma consulta.");
    }
}