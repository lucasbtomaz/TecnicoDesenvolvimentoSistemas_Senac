package br.com.pridecare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    // Getters e Setters
    public int getidConsulta() {
        return idConsulta;
    }

    public Date getdataHora() {
        return dataHora;
    }
    
    // Métodos
    public void marcarConsulta() {
        // Implementar lógica
    }
    
    public void consultarConsulta() {
        // Implementar lógica
    }

}
