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
public class Consulta {
    private int idConsulta;
    private Date dataHora;
    private Paciente paciente;
    private Medico medico;
    private Prontuario prontuario;
    private String observacao;

    public Consulta(int idConsulta, Date dataHora, Paciente paciente, Medico medico, Prontuario prontuario) {
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.medico = medico;
        this.prontuario = prontuario;
    }
    
    // Getters e Setters
    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    
    // Métodos
    public void marcarConsulta() {
        // Implementar lógica
        System.out.println("Consulta marcada: " + this.idConsulta);
    }
    
    public void consultarConsulta() {
        // Implementar lógica
        System.out.println("Consulta consultada: " + this.idConsulta);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
