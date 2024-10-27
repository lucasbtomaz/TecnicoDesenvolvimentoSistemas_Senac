/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare;

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
    
    // Getters e Setters
    public int getIdPaciente(){
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getOrientacaoSexual() {
        return orientacaoSexual;
    }

    public void setOrientacaoSexual(String orientacaoSexual) {
        this.orientacaoSexual = orientacaoSexual;
    }
    
    // Métodos
    public void cadastrarPaciente() {
        // Continuar a implementação da lógica
        System.out.println("Paciente cadastrado: " + this.nome);
    }
    
    public void consultarPaciente() {
        // Continuar a implementação da lógica
        System.out.println("Consulta ao paciente: " + this.nome);
    }
}
