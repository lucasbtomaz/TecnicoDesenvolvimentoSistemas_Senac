package br.com.pridecare.data;

import br.com.pridecare.dao.ReceitaDAO;
import br.com.pridecare.dao.UsuarioDAO;
import br.com.pridecare.model.Usuario;
import br.com.pridecare.entity.Functions;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe de serviço para operações relacionadas a Usuários
 *
 * @autor oluca
 */
public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final ReceitaDAO receitaDAO = new ReceitaDAO();

    /**
     * Lista todos os Usuários
     *
     * @return a lista de usuários
     */
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listar();
    }

    /**
     * Método para realizar login e verificar a necessidade de troca de senha
     *
     * @param usuario O usuário
     * @param senhaDigitada A senha digitada pelo usuário
     * @return true se o login for bem-sucedido, false caso contrário
     */
    public boolean login(Usuario usuario, String senhaDigitada) {
        if (usuario.getSenha().equals(senhaDigitada)) {
            if (usuario.isAlterarSenha()) {
                exibirPopupRedefinirSenha(usuario);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para exibir o popup de redefinição de senha e atualizar no usuário
     *
     * @param usuario O usuário
     */
    private void exibirPopupRedefinirSenha(Usuario usuario) {
        String novaSenha = obterNovaSenhaDoUsuario();
        usuario.setSenha(novaSenha);
        usuario.setAlterarSenha(false);
        salvarUsuario(usuario);
    }

    /**
     * Método fictício para obter nova senha do usuário
     *
     * @return Uma nova senha gerada
     */
    private String obterNovaSenhaDoUsuario() {
        return "novaSenhaExemplo";
    }

    /**
     * Salva o usuário no banco de dados, após atualização da senha
     *
     * @param usuario O usuário a ser atualizado
     */
    private void salvarUsuario(Usuario usuario) {
        usuarioDAO.atualizarUsuario(usuario);
    }

    /**
     * Método para gerar uma senha temporária para novos cadastros
     *
     * @return Uma senha temporária gerada
     */
    public String gerarSenhaTemporaria() {
        return Functions.gerarSenhaTemporaria();
    }

    /**
     * Método para cadastrar o usuário e gerar a senha temporária.
     *
     * @param usuario Usuário a ser cadastrado.
     * @return O usuário atualizado com a senha temporária.
     * @throws java.sql.SQLException
     */
    public Usuario cadastrarUsuario(Usuario usuario) throws SQLException {
        String senhaTemporaria = gerarSenhaTemporaria();
        usuario.setSenha(senhaTemporaria);
        usuario.setAlterarSenha(true);
        usuarioDAO.salvarUsuario(usuario);
        return usuario;
    }

    /**
     * * Busca um usuário pelo CPF
     *
     *
     * @param cpf o CPF a ser buscado
     * @return o usuário encontrado
     */
    public Usuario buscarPorCpf(String cpf) {
        List<Usuario> usuarios = usuarioDAO.buscarPorCpf(cpf);
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    /**
     * * Salva o prontuario do paciente
     *
     *
     * @param usuario
     * @param prontuario
     */
    public void atualizarProntuario(Usuario usuario, String prontuario) {
        usuario.setProntuario(prontuario);
        usuarioDAO.atualizarUsuario(usuario);
    }

}
