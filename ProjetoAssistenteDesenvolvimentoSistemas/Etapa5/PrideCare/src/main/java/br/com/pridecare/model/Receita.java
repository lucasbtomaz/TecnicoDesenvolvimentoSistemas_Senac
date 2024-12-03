package br.com.pridecare.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cpf_usuario", nullable = false)
    private String cpfUsuario;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReceita status;

    @ElementCollection
    @CollectionTable(name = "receita_medicamentos", joinColumns = @JoinColumn(name = "receita_id"))
    @Column(name = "medicamento")
    private List<String> medicamentos;

    @ElementCollection
    @CollectionTable(name = "receita_quantidades", joinColumns = @JoinColumn(name = "receita_id"))
    @Column(name = "quantidade")
    private List<Integer> quantidades;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusReceita getStatus() {
        return status;
    }

    public void setStatus(StatusReceita status) {
        this.status = status;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(List<Integer> quantidades) {
        this.quantidades = quantidades;
    }
}
