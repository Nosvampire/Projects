/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "viewmanager")
@SessionScoped
public class ViewManager implements Serializable {
    
    private String url = "inicio.xhtml";
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void setConsultarAutor() {
        setUrl("ConsAutores.xhtml");
    }
    
    public void setInicio() {
        setUrl("inicio.xhtml");
    }
    
    public void setInsertarAutor() {
        setUrl("InsertaAutor.xhtml");
    }
    
    public void setConsultarTitulo() {
        setUrl("ConsTitulo.xhtml");
    }
}
