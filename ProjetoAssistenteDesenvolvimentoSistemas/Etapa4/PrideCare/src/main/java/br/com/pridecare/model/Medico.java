package br.com.pridecare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;
    private String nome;
    private String especialidade;

    // Métodos getters
    public int getidMedico() {
        return idMedico;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    // Métodos
    public void cadastrarMedico() {
        // Implementar lógica
    }
    
    public void consultarMedico() {
        // Implementar lógica
    }

}
