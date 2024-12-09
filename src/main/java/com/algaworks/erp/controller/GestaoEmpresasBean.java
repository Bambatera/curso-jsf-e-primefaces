package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.repository.Empresas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ManagedBean do Cadastro de Empresas
 * 
 * @author Leandro Menezes
 * @version 0.0.1
 * @since 0.0.1-SNAPSHOT
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;
    
    private List<Empresa> listaEmpresas = new ArrayList<>();

    public void carregarEmpresas() {
        this.empresas.pesquisar();
    }
    
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
    
    
}
