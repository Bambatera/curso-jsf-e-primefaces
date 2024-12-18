package com.algaworks.erp.controller;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.repository.RamoAtividades;
import com.algaworks.erp.service.CadastroEmpresaService;
import com.algaworks.erp.util.FacesMessages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.convert.Converter;
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
    
    @Inject
    private CadastroEmpresaService cadastroEmpresaService;
    
    @Inject
    private FacesMessages messages;
    
    @Inject
    private RamoAtividades ramosAtividades;
    
    private Converter ramoAtividadeConverter;
    
    private List<Empresa> listaEmpresas = new ArrayList<>();
    private String termoPesquisa;
    
    private Empresa empresa;
    
    public void carregarEmpresas() {
        this.listaEmpresas = this.empresas.pesquisar();
    }
    
    public List<RamoAtividade> ramoAtividadeAutoComplete(String termo) {
        List<RamoAtividade> listaRamosAtividades = this.ramosAtividades.pesquisar(termo);
        this.ramoAtividadeConverter = new RamoAtividadeConverter(listaRamosAtividades);
        return listaRamosAtividades;
    }
    
    public void pesquisar() {
        this.listaEmpresas = this.empresas.pesquisar(termoPesquisa);
        if (this.listaEmpresas.isEmpty()) {
            this.messages.info("Sua consulta não retornou resultados!");
        }
    }
    
    public void prepararNovaEmpresa() {
        this.empresa = new Empresa();
    }
    
    public void salvar() {
        this.cadastroEmpresaService.salvar(empresa);
        if (jaHouvePesquisa()) {
            this.pesquisar();
        } else {
            this.carregarEmpresas();
        }
        this.messages.info("Empresa cadastrada com sucesso!");
    }
    
    public boolean jaHouvePesquisa() {
        return this.termoPesquisa != null && !"".equals(termoPesquisa);
    }
    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public String getTermoPesquisa() {
        return termoPesquisa;
    }

    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
    public TipoEmpresa[] getTipoEmpresa() {
        return TipoEmpresa.values();
    }

    public Converter getRamoAtividadeConverter() {
        return ramoAtividadeConverter;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
