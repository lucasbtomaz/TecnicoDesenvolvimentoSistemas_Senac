package br.com.pridecare.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária para gerenciar o EntityManager e a EntityManagerFactory do JPA.
 */
public class JPAUtil {
    private static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("pridecare");
        } catch (Throwable ex) {
            System.err.println("Falha ao criar o EntityManagerFactory. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retorna uma instância de EntityManager.
     *
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    /**
     * Fecha a EntityManagerFactory quando não for mais necessária.
     */
    public static void close() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}
