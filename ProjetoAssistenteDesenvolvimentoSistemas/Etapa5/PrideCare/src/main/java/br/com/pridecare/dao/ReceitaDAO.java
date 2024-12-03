package br.com.pridecare.dao;

import br.com.pridecare.model.Receita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Classe responsável pela interação direta com a tabela de receitas no banco de
 * dados.
 */
public class ReceitaDAO {

    public void salvarReceita(Receita receita) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(receita);
            em.getTransaction().commit();
        }
    }

    public List<Receita> buscarPorCpf(String cpfUsuario) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            TypedQuery<Receita> query = em.createQuery("SELECT r FROM Receita r WHERE r.cpfUsuario = :cpfUsuario", Receita.class);
            query.setParameter("cpfUsuario", cpfUsuario);
            return query.getResultList();
        }
    }

    // Adicionar o método buscarPorId 
    public Receita buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Receita.class, id);
        } finally {
            em.close();
        }
    }
}
