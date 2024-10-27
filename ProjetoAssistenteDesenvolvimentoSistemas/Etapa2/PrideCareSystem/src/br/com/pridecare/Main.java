/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare;

import br.com.pridecare.Model.Consulta;
import br.com.pridecare.Model.Farmacia;
import br.com.pridecare.Model.Funcionario;
import br.com.pridecare.Model.Medicamento;
import br.com.pridecare.Model.Medico;
import br.com.pridecare.Model.Paciente;
import br.com.pridecare.Model.Prontuario;
import java.util.Date;

/**
 *
 *  oluca
 */
public class Main {
    public static void main(String[] args) {
        // Simulação de uso do sistema com diferentes atores

        // Simulando um paciente
        Paciente paciente = new Paciente(1, "João", "Silva", new Date(), 'M', "Homossexual");
        paciente.consultarInformacoes();
        paciente.marcarConsulta();

         // Simulando um funcionário
        Funcionario funcionario = new Funcionario(101, "Maria", "Recepcionista");
        Paciente novoPaciente = new Paciente(2, "Maria", "Santos", new Date(), 'F', "Heterossexual");
        funcionario.cadastrarPaciente(novoPaciente);
        Consulta consulta = new Consulta(1, new Date(), novoPaciente, null, null); // Médico e Prontuário ainda não atribuídos
        funcionario.marcarConsulta(consulta);
        
        Farmacia farmacia = new Farmacia(1, new Date(), new Medicamento(1, "Paracetamol", "Analgésico"), funcionario, novoPaciente);
        funcionario.liberarMedicamentos(farmacia);
        funcionario.atualizarProntuario(novoPaciente, "Paciente estável");

        // Simulando um médico
        Medico medico = new Medico(201, "Dr. Carlos", "Clínico Geral");
        Consulta consultaPaciente = new Consulta(2, new Date(), novoPaciente, medico, new Prontuario(1, novoPaciente));
        medico.atualizarConsulta(consultaPaciente, "Paciente responde bem ao tratamento");
        medico.receitarMedicamentos(novoPaciente, new Medicamento(2, "Amoxicilina", "Antibiótico"), 1);

        System.out.println("Operações realizadas com sucesso!");
    }
}