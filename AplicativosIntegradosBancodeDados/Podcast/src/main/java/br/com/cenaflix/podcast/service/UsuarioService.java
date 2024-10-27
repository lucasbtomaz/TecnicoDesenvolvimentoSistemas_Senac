package br.com.cenaflix.podcast.service;

import br.com.cenaflix.podcast.Usuario;
import br.com.cenaflix.podcast.persistencia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

/**
 * Classe responsável por validar o login dos usuários e obter os dados do
 * usuário.
 */
public class UsuarioService {

    /**
     * Valida o login do usuário usando JPA e obtém suas informações.
     *
     * @param login o login do usuário
     * @param senha a senha do usuário (já criptografada, se necessário)
     * @return um objeto Usuario contendo as informações do usuário (nome,
     * login, tipo) ou null se não encontrar
     */
    public Usuario validarLogin(String login, String senha) {
        EntityManager em = JPAUtil.getEntityManager();
        Usuario usuarioLogado = null;
        
        System.out.println("Tentativa de login - Login: " + login + ", Senha: " + senha);

        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            usuarioLogado = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum usuário encontrado com essas credenciais.");
        } finally {
            em.close();
        }

        return usuarioLogado;
    }

    /**
     * Verifica as permissões do usuário com base no tipo de acesso.
     *
     * @param usuario o usuário que fez login
     * @return as permissões que o usuário tem no sistema
     */
    public String verificarPermissoes(Usuario usuario) {
        String tipo = usuario.getTipo();
        return switch (tipo) {
            case "Admin" -> "acessoTotal";
            case "Operador" -> "cadastroListagem";
            case "Usuario" -> "somenteListagem";
            default -> "nenhumaPermissao";
        }; 
    }

}
