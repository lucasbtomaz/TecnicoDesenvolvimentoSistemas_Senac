package br.com.pridecare.dao;

import br.com.pridecare.data.DatabaseConnection;
import br.com.pridecare.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Responsabilidade de interação direta no banco de dados.
 */
public class UsuarioDAO {

    /**
     * Atualiza um usuário no banco de dados.
     * @param usuario o usuário a ser atualizado
     */
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome_completo = ?, data_nascimento = ?, genero = ?, orientacao_sexual = ?, senha = ?, email = ?, telefone = ?, data_entrada = ?, tipo_usuario = ?, especialidade = ?, crm = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setDate(2, usuario.getDataNascimento());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getOrientacaoSexual());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getTelefone());
            stmt.setDate(8, usuario.getDataEntrada());
            stmt.setString(9, usuario.getTipoUsuario());
            stmt.setString(10, usuario.getEspecialidade());
            stmt.setString(11, usuario.getCrm());
            stmt.setInt(12, usuario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o usuário: " + e.getMessage());
        }
    }

    /**
     * Salva um novo usuário no banco de dados.
     * @param usuario o usuário a ser salvo
     * @throws SQLException se ocorrer um erro ao salvar o usuário
     */
    public void salvarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome_completo, cpf, data_nascimento, genero, orientacao_sexual, email, telefone, senha, tipo_usuario, data_entrada, especialidade, crm) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setDate(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getGenero());
            stmt.setString(5, usuario.getOrientacaoSexual());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getTelefone());
            stmt.setString(8, usuario.getSenha());
            stmt.setString(9, usuario.getTipoUsuario());
            stmt.setDate(10, usuario.getDataEntrada());
            stmt.setString(11, usuario.getEspecialidade());
            stmt.setString(12, usuario.getCrm());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao cadastrar o usuário, nenhum registro afetado.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao cadastrar o usuário, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Lista todos os usuários.
     * @return a lista de usuários
     */
    public List<Usuario> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios = null;
        try {
            Query consulta = em.createQuery("SELECT u FROM Usuario u");
            usuarios = consulta.getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }

    /**
     * Busca usuários pelo CPF.
     * @param cpf o CPF a ser buscado
     * @return a lista de usuários encontrados
     */
    public List<Usuario> buscarPorCpf(String cpf) {
        EntityManager em = JPAUtil.getEntityManager();
        List<Usuario> usuarios = null;
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cpf = :cpf", Usuario.class);
            query.setParameter("cpf", cpf);
            usuarios = query.getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }
}
