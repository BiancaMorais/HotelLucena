/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.converter;

import br.cesjf.hotellucena.model.Categoria;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Tassio
 */
@FacesConverter("categoriaConverter")
@ManagedBean
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (Categoria) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof Categoria) {
            Categoria categoria = (Categoria) value;
            if (categoria != null && categoria instanceof Categoria && categoria.getCodigoCategoria() != null) {
                uic.getAttributes().put(categoria.getCodigoCategoria().toString(), categoria);
                return categoria.getCodigoCategoria().toString();
            }
        }
        return "";
    }
}
