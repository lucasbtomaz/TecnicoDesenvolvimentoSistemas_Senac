package br.com.pridecare.dao;

import br.com.pridecare.model.ReceitaMedicamento;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ReceitaMedicamentoDAO {

    public void salvarReceitaMedicamento(ReceitaMedicamento receitaMedicamento) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(receitaMedicamento);
            em.getTransaction().commit();
        }
    }

    public List<ReceitaMedicamento> buscarPorReceita(int receitaId) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return em.createQuery("SELECT rm FROM ReceitaMedicamento rm WHERE rm.receita.id = :receitaId", ReceitaMedicamento.class)
                     .setParameter("receitaId", receitaId)
                     .getResultList();
        }
    }
}
