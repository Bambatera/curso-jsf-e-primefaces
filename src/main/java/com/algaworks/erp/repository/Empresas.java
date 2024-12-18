package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author leand
 */
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresas() {
    }

    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    public Empresa porId(Long id) {
        try {
            return this.manager.find(Empresa.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Empresa> pesquisar() {
        List<Empresa> empresas = new ArrayList<>();
        try {
            empresas = this.manager.createQuery("FROM Empresa e ORDER BY e.razaoSocial ASC", Empresa.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return empresas;
    }

    public List<Empresa> pesquisar(String nome) {
        List<Empresa> empresas = new ArrayList<>();
        try {
            TypedQuery<Empresa> query = this.manager.createQuery("FROM Empresa e WHERE LOWER(e.razaoSocial) LIKE LOWER(:razaoSocial)", Empresa.class);
            query.setParameter("razaoSocial", "%" + nome + "%");
            empresas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return empresas;
    }

    public Empresa guardar(Empresa empresa) {
        return this.manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = this.porId(empresa.getId());
        this.manager.remove(empresa);
    }
}
