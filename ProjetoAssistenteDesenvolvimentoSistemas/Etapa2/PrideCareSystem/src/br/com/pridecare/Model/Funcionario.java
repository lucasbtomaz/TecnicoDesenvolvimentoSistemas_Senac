/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

/**
 *
 *  oluca
 */
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String cargo;

    public Funcionario(int idFuncionario, String nome, String cargo) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cargo = cargo;
    }

    // Getters
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    // Métodos específicos para funcionários
    public void cadastrarPaciente(Paciente paciente) {
        System.out.println("Funcionário " + this.nome + " cadastrou o paciente " + paciente.getNome());
    }

    public void marcarConsulta(Consulta consulta) {
        System.out.println("Funcionário " + this.nome + " marcou a consulta para o paciente " + consulta.getPaciente().getNome());
    }

    public void liberarMedicamentos(Farmacia farmacia) {
        System.out.println(farmacia.getPaciente().getNome() + " Funcionário " + this.nome + " liberou medicamentos para o paciente ");
    }

    public void atualizarProntuario(Paciente paciente, String observacao) {
        Prontuario prontuario = paciente.getProntuario();
        if (prontuario != null) {
            prontuario.setObservacao(observacao);
            System.out.println("Prontuário do paciente " + paciente.getNome() + " atualizado por " + this.nome);
        } else {
            System.out.println("Paciente " + paciente.getNome() + " não possui prontuário.");
        }
    }
}