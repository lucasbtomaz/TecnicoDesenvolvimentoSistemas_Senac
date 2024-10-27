/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por estabelecer a conexão com o banco de dados MySQL. Esta
 * classe fornece um método para obter a conexão com o banco de dados.
 *
 *  oluca
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/cenaflix";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return a conexão com o banco de dados
     * @throws SQLException se ocorrer um erro ao estabelecer a conexão
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new SQLException("Erro ao conectar ao banco de dados: " + ex.getMessage()
                    + ". Verifique se o banco de dados está acessível e as credenciais estão corretas.");
        }
    }

}
