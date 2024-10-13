/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import atividade1.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oluca
 */
public class FilmeDAO {

    private Connection conn;

    public boolean conectar() throws ClassNotFoundException {
        try {
            // Verifica se o driver do MySQL está presente no classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Tentando conectar...");

            // Estabelecer a conexão
            conn = DatabaseConnection.getConnection();
            System.out.println("Conexão realizada com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha na conexao " + ex.getMessage());
            return false;
        }
    }

    public boolean inserirFilme(Filme filme) throws SQLException {
        String sql = "INSERT INTO filmes (nome, categoria, datalancamento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getCategoria());
            stmt.setDate(3, filme.getDataLancamento());  
            return stmt.executeUpdate() > 0; 
        }
    }

    public List<Filme> listarFilmes() throws SQLException {
        String sql = "SELECT * FROM filmes";
        List<Filme> filmes = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("id"));
                filme.setNome(rs.getString("nome"));
                filme.setCategoria(rs.getString("categoria"));
                filme.setDataLancamento(rs.getDate("datalancamento"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public void atualizarFilme(Filme filme) throws SQLException {
        String sql = "UPDATE filmes SET nome = ?, categoria = ?, datalancamento = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getCategoria());
            stmt.setDate(3, filme.getDataLancamento());
            stmt.setInt(4, filme.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirFilme(int id) throws SQLException {
        String sql = "DELETE FROM filmes WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void desconectar() {
        try {
            // Verifica se a conexão está aberta antes de fechar
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada com sucesso.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar: " + ex.getMessage());
        }
    }
}
