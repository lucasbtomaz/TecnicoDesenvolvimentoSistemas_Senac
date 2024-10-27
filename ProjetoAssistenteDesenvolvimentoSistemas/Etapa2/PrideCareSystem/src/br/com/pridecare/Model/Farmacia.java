/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

import br.com.pridecare.Model.Paciente;
import java.util.Date;

/**
 *
 *  oluca
 */
public class Farmacia {
    private int idTransacao;
    private Date dataHora;
    private Medicamento medicamento;
    private Funcionario funcionario;
    private Paciente paciente;

    public Farmacia(int idTransacao, Date dataHora, Medicamento medicamento, Funcionario funcionario, Paciente paciente) {
        this.idTransacao = idTransacao;
        this.dataHora = dataHora;
        this.medicamento = medicamento;
        this.funcionario = funcionario;
        this.paciente = paciente;
    }

    // Métodos específicos para farmácia
    public void liberarMedicamento() {
        System.out.println("Medicamento " + medicamento.getNome() + " liberado para o paciente " + paciente.getNome() + " por " + funcionario.getNome());
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

}