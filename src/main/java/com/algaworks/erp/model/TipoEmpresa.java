package com.algaworks.erp.model;

/**
 *
 * @author leand
 */
public enum TipoEmpresa {
    
    MEI("Micro Empreendedor Individual"),
    EIRELI("Empresa Individual de Responsabilidade Limitada"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anônima");
    
    private String descricao;

    private TipoEmpresa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
