package br.com.cenaflix.podcast.persistencia;

import br.com.cenaflix.podcast.Podcast;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 * Classe DAO responsável por operações de banco de dados para Podcast.
 *
 *  oluca
 */
public class PodcastDAO {

    /**
     * Cadastra um novo podcast no banco de dados.
     *
     * @param podcast o podcast a ser cadastrado
     */
    public void cadastrar(Podcast podcast) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(podcast);  
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Lista todos os podcasts cadastrados no banco de dados.
     *
     * @return uma lista contendo todos os podcasts
     */
    public List<Podcast> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Podcast> podcasts = null;
        try {
            Query consulta = em.createQuery("SELECT d FROM Podcast d");
            podcasts = consulta.getResultList();  
        } finally {
            em.close();  
        }
        return podcasts;  
    }

    /**
     * Exclui um podcast do banco de dados com base no ID fornecido.
     *
     * @param id o ID do podcast a ser excluído
     */
    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Podcast podcast = em.find(Podcast.class, id);  
            if (podcast != null) {
                em.getTransaction().begin();
                em.remove(podcast);  
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();  
        }
    }
}

