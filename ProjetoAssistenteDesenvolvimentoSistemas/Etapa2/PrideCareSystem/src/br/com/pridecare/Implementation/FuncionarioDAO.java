/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pridecare.Implementation;

import br.com.pridecare.Interface.IFuncionarioDAO;
import br.com.pridecare.Model.Funcionario;
import br.com.pridecare.Util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *  oluca
 */
public class FuncionarioDAO implements IFuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario (id, nome, cargo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, funcionario.getIdFuncionario());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getCargo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Funcionario findById(int id) {
        Funcionario funcionario = null;
        try {
            String sql = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idFuncionario = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cargo = resultSet.getString("cargo");

                funcionario = new Funcionario(idFuncionario, nome, cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}
