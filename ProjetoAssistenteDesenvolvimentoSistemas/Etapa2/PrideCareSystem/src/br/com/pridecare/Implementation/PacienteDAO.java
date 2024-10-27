/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Implementation;

import br.com.pridecare.Interface.IPacienteDAO;
import br.com.pridecare.Model.Paciente;
import br.com.pridecare.Util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *  oluca
 */
public class PacienteDAO implements IPacienteDAO {

    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public PacienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para salvar um paciente no banco de dados
    @Override
    public void save(Paciente paciente) {
        try {
            String sql = "INSERT INTO paciente (id, nome, sobrenome, dataNascimento, genero, orientacaoSexual) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, paciente.getIdPaciente());
            statement.setString(2, paciente.getNome());
            statement.setString(3, paciente.getSobrenome());
            statement.setDate(4, new java.sql.Date(paciente.getDataNascimento().getTime()));
            statement.setString(5, String.valueOf(paciente.getGenero()));
            statement.setString(6, paciente.getOrientacaoSexual());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um paciente pelo ID no banco de dados
    @Override
    public Paciente findById(int id) {
        Paciente paciente = null;
        try {
            String sql = "SELECT * FROM paciente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int pacienteId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                java.util.Date dataNascimento = resultSet.getDate("dataNascimento");
                char genero = resultSet.getString("genero").charAt(0);
                String orientacaoSexual = resultSet.getString("orientacaoSexual");

                paciente = new Paciente(pacienteId, nome, sobrenome, dataNascimento, genero, orientacaoSexual);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
}
