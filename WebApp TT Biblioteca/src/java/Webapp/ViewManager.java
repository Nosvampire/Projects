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

    public void setInicio() {
        setUrl("inicio.xhtml");
    }

    public void setConsultarTitulo() {
        setUrl("ConsTitulo.xhtml");
    }

    public void setInsTitulo() {
        setUrl("InsTitulo.xhtml");
    }

    public void setModTitulo() {
        setUrl("ConsModTitulo.xhtml");
    }

    public void setConsultarCurso() {
        setUrl("ResConsCurso.xhtml");
    }

    public void setConsultarPais() {
        setUrl("ConsPais.xhtml");
    }

    public void setConsultarPrestamo() {
        setUrl("ConsPrestamo.xhtml");
    }

    public void setConsultarCondicion() {
        setUrl("ResConsCondicion.xhtml");
    }

    public void setInsCondicion() {
        setUrl("InsCondicion.xhtml");
    }

    public void setConsModCondicion() {
        setUrl("ResModCondicion.xhtml");
    }

    public void setElimCondicion() {
        setUrl("ElimCondicion.xhtml");
    }

    public void setInsCurso() {
        setUrl("InsCurso.xhtml");
    }

    public void setConsModCurso() {
        setUrl("ResConsModCurso.xhtml");
    }

    public void setElimCurso() {
        setUrl("ElimCurso.xhtml");
    }

    public void setConsEditorial() {
        setUrl("ResConsEditorial.xhtml");
    }

    public void setInsEditorial() {
        setUrl("InsEditorial.xhtml");
    }

    public void setModEditorial() {
        setUrl("ResModEditorial.xhtml");
    }

    public void setElimEditorial() {
        setUrl("ResConsElimEditorial.xhtml");
    }

    public void setConsCategoria() {
        setUrl("ResConsCategoria.xhtml");
    }

    public void setInsCategoria() {
        setUrl("InsCategoria.xhtml");
    }

    public void setModCategoria() {
        setUrl("ResModCategoria.xhtml");
    }

    public void setElimCategoria() {
        setUrl("ResConsElimCategoria.xhtml");
    }

    public void setConsPais() {
        setUrl("ResConsPais.xhtml");
    }

    public void setInsPais() {
        setUrl("InsPais.xhtml");
    }

    public void setModPais() {
        setUrl("ResModPais.xhtml");
    }

    public void setElimPais() {
        setUrl("ResConsElimPais.xhtml");
    }

    public void setConsAutor() {
        setUrl("ConsAutores.xhtml");
    }

    public void setInsAutor() {
        setUrl("InsertaAutor.xhtml");
    }

    public void setModAutor() {
        setUrl("ConsModAutor.xhtml");
    }

    public void setElimAutor() {
        setUrl("ConsElimAutor.xhtml");
    }

    public void setModPrestamo() {
        setUrl("ConsModPrestamo.xhtml");
    }

    public void setConsDewey() {
        setUrl("ResConsDewey.xhtml");
    }

    public void setInsDewey() {
        setUrl("InsDewey.xhtml");
    }

    public void setModDewey() {
        setUrl("ResModDewey.xhtml");
    }

    public void setElimDewey() {
        setUrl("ResConsElimDewey.xhtml");
    }

}
