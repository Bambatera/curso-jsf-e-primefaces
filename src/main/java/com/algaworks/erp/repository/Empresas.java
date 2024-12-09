package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import java.io.Serializable;
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
        return this.manager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar() {
        return this.manager.createQuery("FROM Empresa ORDER BY razaoSocial ASC", Empresa.class).getResultList();
    }

    public List<Empresa> pesquisar(String nome) {
        TypedQuery<Empresa> query = this.manager.createQuery("FROM Empresa WHERE nomeFantasia LIKE :nomeFantasia", Empresa.class);
        query.setParameter("nomeFantasia", nome + "%");
        return query.getResultList();
    }

    public Empresa guardar(Empresa empresa) {
        return this.manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        empresa = this.porId(empresa.getId());
        this.manager.remove(empresa);
    }
}
