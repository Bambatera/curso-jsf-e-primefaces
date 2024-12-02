package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe de teste inicial.
 * <p>
 * Classe para teste de acesso, conexão com o banco de dados e criação das
 * tabelas e dados.</p>
 *
 * @author Leandro Menezes
 */
public class SchemaGeneration {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaworksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("FROM Empresa", Empresa.class).getResultList();

        System.out.println(lista);
        em.close();
        emf.close();
    }
}
