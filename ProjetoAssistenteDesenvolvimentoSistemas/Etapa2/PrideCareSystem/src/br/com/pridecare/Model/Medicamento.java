/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Model;

/**
 *
 *  oluca
 */
public class Medicamento {
    private int idMedicamento;
    private String nome;
    private String descricao;

    public Medicamento(int idMedicamento, String nome, String descricao) {
        this.idMedicamento = idMedicamento;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getter para nome do medicamento
    public String getNome() {
        return nome;
    }

}

