package br.com.pridecare.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe DatabaseConnection responsável por gerenciar a conexão com o banco de dados.
 * <p>
 * A classe oferece um método estático para obter uma conexão com o banco de dados.
 * </p>
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/PrideCare";
    private static final String USER = "root";
    private static final String PASSWORD = "";

     /**
     * Retorna uma conexão ativa com o banco de dados.
     *
     * @return Conexão com o banco de dados.
     * @throws SQLException Se ocorrer um erro ao conectar ao banco de dados.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }    
}
