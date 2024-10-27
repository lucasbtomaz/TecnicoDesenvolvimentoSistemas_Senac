/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare;

/**
 *
 *  oluca
 */
public class Main {
    public static void main(String[] args) {
        // Criar instância de Paciente
        Paciente paciente = new Paciente();
        
        // Configurar atributos do paciente
        paciente.setIdPaciente(1);
        paciente.setNome("João");
        paciente.setSobrenome("Silva");
        paciente.setDataNascimento(new java.util.Date());
        paciente.setGenero('M');
        paciente.setOrientacaoSexual("Homossexual");
        
        // Cadastrar paciente
        paciente.cadastrarPaciente();
        
        // Consultar paciente
        paciente.consultarPaciente();
        
        System.out.println("Paciente cadastrado e consultado com sucesso!");
    }
    
}
