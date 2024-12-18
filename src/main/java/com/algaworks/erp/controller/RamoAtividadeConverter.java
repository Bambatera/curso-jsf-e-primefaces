/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algaworks.erp.controller;

import com.algaworks.erp.model.RamoAtividade;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author leand
 */
public class RamoAtividadeConverter implements Converter {

    private List<RamoAtividade> listaRamosAtividades;

    public RamoAtividadeConverter(List<RamoAtividade> listaRamosAtividades) {
        this.listaRamosAtividades = listaRamosAtividades;
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        
        Long id = Long.valueOf(value);
        
        return this.listaRamosAtividades.stream().filter(ramoAtividade -> id.equals(ramoAtividade.getId())).findFirst().orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        RamoAtividade ramoAtividade = (RamoAtividade) value;
        return ramoAtividade.getId().toString();
    }
    
}
