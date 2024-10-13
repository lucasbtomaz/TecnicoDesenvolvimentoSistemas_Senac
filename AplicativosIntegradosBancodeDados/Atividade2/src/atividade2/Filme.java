/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade2;

import java.sql.Date;

/**
 * Classe que representa um filme.
 * Contém informações sobre o nome, categoria e data de lançamento do filme.
 * 
 * @author oluca
 */
public class Filme {

    private int id;
    private String nome;
    private String categoria;
    private Date dataLancamento;

    /**
     * Construtor que aceita nome, categoria e data de lançamento.
     * 
     * @param nome o nome do filme
     * @param categoria a categoria do filme
     * @param dataLancamento a data de lançamento do filme
     */
    public Filme(String nome, String categoria, Date dataLancamento) {
        this.nome = nome;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
