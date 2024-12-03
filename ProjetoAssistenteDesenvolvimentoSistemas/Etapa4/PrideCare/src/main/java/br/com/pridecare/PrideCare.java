package br.com.pridecare;

import br.com.pridecare.model.Paciente;

public class PrideCare {
    public static void main(String[] args) {

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(1);
        paciente.setNome("João");
        paciente.setSobrenome("Silva");
        
        System.out.println("Paciente criado com sucesso: " + paciente.getNome());

        // Operações sem persistência (Banco de Dados)
        System.out.println("Consulta a paciente: " + paciente.getNome() + " " + paciente.getSobrenome());
    }
}
