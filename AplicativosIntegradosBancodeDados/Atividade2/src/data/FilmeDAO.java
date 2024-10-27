/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import atividade2.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por realizar operações de acesso a dados relacionadas a
 * filmes. Inclui métodos para inserir, buscar, atualizar e excluir filmes no
 * banco de dados.
 *
 *  oluca
 */
public class FilmeDAO {

    private Connection conn;

    /**
     * Conecta ao banco de dados MySQL.
     *
     * @return true se a conexão for bem-sucedida, false caso contrário
     * @throws ClassNotFoundException se o driver do MySQL não for encontrado
     */
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
            System.out.println("Falha na conexão: " + ex.getMessage()
                    + ". Por favor, verifique se o banco de dados está acessível.");
            return false;
        }
    }

    /**
     * Insere um novo filme no banco de dados.
     *
     * @param filme o objeto Filme a ser inserido
     * @return true se a inserção for bem-sucedida, false caso contrário
     * @throws SQLException se ocorrer um erro durante a operação
     */
    public boolean inserirFilme(Filme filme) throws SQLException {
        String sql = "INSERT INTO filmes (nome, categoria, datalancamento) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getCategoria());
            stmt.setDate(3, filme.getDataLancamento());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível inserir os dados! Por favor, verifique os valores digitados: " + ex.getMessage());
        }
    }

    public List<Filme> buscarFilmesPorNome(String nome) throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM filmes WHERE nome LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme(rs.getString("nome"), rs.getString("categoria"), rs.getDate("dataLancamento"));
                filme.setId(rs.getInt("id"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public List<Filme> buscarFilmesPorCategoria(String categoria) throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM filmes WHERE categoria LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + categoria + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme(rs.getString("nome"), rs.getString("categoria"), rs.getDate("dataLancamento"));
                filme.setId(rs.getInt("id"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    public List<Filme> buscarFilmesPorNomeECategoria(String nome, String categoria) throws SQLException {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM filmes WHERE nome LIKE ? AND categoria LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + categoria + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme(rs.getString("nome"), rs.getString("categoria"), rs.getDate("dataLancamento"));
                filme.setId(rs.getInt("id"));
                filmes.add(filme);
            }
        }
        return filmes;
    }

    /**
     * Atualiza um filme existente no banco de dados.
     *
     * @param filme O objeto Filme com as informações atualizadas.
     * @throws SQLException se ocorrer um erro ao atualizar o filme.
     */
    public void atualizarFilme(Filme filme) throws SQLException {
        String sql = "UPDATE filmes SET nome = ?, categoria = ?, datalancamento = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filme.getNome());
            stmt.setString(2, filme.getCategoria());
            stmt.setDate(3, filme.getDataLancamento());
            stmt.setInt(4, filme.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível atualizar os dados do filme! " + ex.getMessage());
        }
    }

    public void excluirFilme(int id) throws SQLException {
        String sql = "DELETE FROM filmes WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Não foi possível excluir o filme! " + ex.getMessage());
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
