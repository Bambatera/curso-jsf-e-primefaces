package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author leand
 */
@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();

    public GestaoEmpresasBean() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public TipoEmpresa[] getTiposEmpresa() {
        return TipoEmpresa.values();
    }
    
    public void salvar() {
        System.out.println("Razão Social: " + empresa.getRazaoSocial()
            + "\nNome Fantasia: " + empresa.getNomeFantasia()
            + "\nTipo: " + empresa.getTipo());
    }
}
