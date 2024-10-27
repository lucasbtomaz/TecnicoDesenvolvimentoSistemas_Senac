package br.com.cenaflix.podcast.service;

import br.com.cenaflix.podcast.Podcast;
import br.com.cenaflix.podcast.persistencia.PodcastDAO;
import java.util.List;

/**
 * Classe responsável pela lógica de negócio de podcasts, incluindo cadastro.
 *
 */
public class PodcastService {

    private final PodcastDAO podcastDAO = new PodcastDAO();  

    /**
     * Método responsável por cadastrar um novo podcast no banco de dados.
     *
     * @param podcast o podcast a ser cadastrado
     */
    public void cadastrarPodcast(Podcast podcast) {
        podcastDAO.cadastrar(podcast);
    }

    /**
     * Lista todos os podcasts cadastrados.
     *
     * @return uma lista de todos os podcasts
     */
    public List<Podcast> listarPodcasts() {
        return podcastDAO.listar();
    }

    /**
     * Exclui um podcast pelo ID, caso o usuário tenha permissão.
     *
     * @param id o ID do podcast a ser excluído
     * @param tipoUsuario
     * @throws SecurityException se o usuário não for um administrador
     */
    public void excluirPodcast(int id, String tipoUsuario) {
        if (!"Admin".equalsIgnoreCase(tipoUsuario)) {
            throw new SecurityException("Apenas administradores podem excluir podcasts.");
        }

        try {
            podcastDAO.excluir(id);
        } catch (Exception e) {
            System.out.println("Erro ao excluir podcast: " + e.getMessage());
            throw e;
        }
    }
}
