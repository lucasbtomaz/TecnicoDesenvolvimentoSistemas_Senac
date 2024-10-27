/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

/**
 *
 *  oluca
 */
public class Medico {

    private int idMedico;
    private String nome;
    private String especialidade;

    public Medico(int idMedico, String nome, String especialidade) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Getters
    public int getIdMedico() {
        return idMedico;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    // Métodos específicos para médicos
    public void atualizarConsulta(Consulta consulta, String observacao) {
        consulta.setObservacao(observacao);
        System.out.println("Consulta atualizada com sucesso por " + this.nome);
    }

    public void receitarMedicamentos(Paciente paciente, Medicamento medicamento, int quantidade) {
        System.out.println("Médico " + this.nome + " receitou " + quantidade + " de " + medicamento.getNome() + " para " + paciente.getNome());
    }
}
