/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

import br.com.pridecare.Model.Paciente;

/**
 *
 *  oluca
 */
public class Prontuario {
    private int idProntuario;
    private Paciente paciente;

    public Prontuario(int idProntuario, Paciente paciente) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
    }
    
    // Métodos
    public void cadastrarProntuario() {
        // Implementar lógica
    }
    
    public void consultarProntuario() {
        // Implementar lógica
    }

    void setObservacao(String observacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
