package com.algaworks.erp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author leand
 */
@Entity
@Table(catalog = "cursojsfprimefaces", name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;

    @NotEmpty
    @Column(name = "razao_social", nullable = false, length = 120)
    private String razaoSocial;

    @CNPJ
    @NotNull
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @NotNull
    @Past
    @Column(name = "data_fundacao")
    @Temporal(TemporalType.DATE)
    private Date dataFundacao;

    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id", nullable = false)
    private RamoAtividade ramoAtividade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 30)
    private TipoEmpresa tipo;
    
    @Column(name = "faturamento", precision = 10, scale = 2)
    private BigDecimal faturamento;
    
    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public RamoAtividade getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(RamoAtividade ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public TipoEmpresa getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(BigDecimal faturamento) {
        this.faturamento = faturamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + '}';
    }

}
