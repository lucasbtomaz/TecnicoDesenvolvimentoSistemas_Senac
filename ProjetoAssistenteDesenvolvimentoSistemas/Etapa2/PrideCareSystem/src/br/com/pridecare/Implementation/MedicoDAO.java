/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Implementation;

import br.com.pridecare.Interface.IMedicoDAO;
import br.com.pridecare.Model.Medico;
import br.com.pridecare.Util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDAO implements IMedicoDAO {
    private Connection connection;

    public MedicoDAO() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void save(Medico medico) {
        try {
            String sql = "INSERT INTO medico (id, nome, especialidade) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, medico.getIdMedico());
            statement.setString(2, medico.getNome());
            statement.setString(3, medico.getEspecialidade());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Método para buscar um médico pelo ID no banco de dados
    @Override
    public Medico findById(int id) {
        Medico medico = null;
        try {
            String sql = "SELECT * FROM medico WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int medicoId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String especialidade = resultSet.getString("especialidade");

                medico = new Medico(medicoId, nome, especialidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }
}