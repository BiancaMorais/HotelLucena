/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.converter;

import br.cesjf.hotellucena.model.Apartamento;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Tassio
 */
@FacesConverter("apartamentoConverter")
@ManagedBean
public class ApartamentoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Apartamento) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Apartamento) {
            Apartamento apto = (Apartamento) value;
            if (apto != null && apto instanceof Apartamento && apto.getIdApartamento()!= null) {
                uic.getAttributes().put(apto.getIdApartamento().toString(), apto);
                return apto.getIdApartamento().toString();
            }
        }
        return "";
    }
}