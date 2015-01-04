/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.AutorFCD;
import FCD.DeweyFCD;
import FCD.TituloFCD;
import POJO.Copia;
import POJO.Dewey;
import POJO.Titulo;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "titulobean")
@SessionScoped
public class TituloBean {

    private int titCod;
    private String titTipo;
    private int deweyCod;
    private Titulo tituloOri = new Titulo();
    private String titNombre;
    private List<Titulo> listTitulo;
    private Copia copia;
    private List<SelectItem> listDewey;
    private Titulo titulo = new Titulo();

    //<editor-fold defaultstate="collapsed" desc="GETTER && SETTER">
    public String getTitNombre() {
        return titNombre;

    }

    public Titulo getTituloOri() {
        return tituloOri;
    }

    public void setTituloOri(Titulo tituloOri) {
        this.tituloOri = tituloOri;
    }

    public void setTitNombre(String titNombre) {
        this.titNombre = titNombre;
    }

    public List<Titulo> getListTitulo() {
        return listTitulo;
    }

    public void setListTitulo(List<Titulo> listTitulo) {
        this.listTitulo = listTitulo;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public int getTitCod() {
        return titCod;
    }

    public void setTitCod(int titCod) {
        this.titCod = titCod;
    }

    public String getTitTipo() {
        return titTipo;
    }

    public void setTitTipo(String titTipo) {
        this.titTipo = titTipo;
    }

    public int getDeweyCod() {
        return deweyCod;
    }

    public void setDeweyCod(int deweyCod) {
        this.deweyCod = deweyCod;
    }

    public List<SelectItem> getListDewey() {
        return listDewey;
    }

    public void setListDewey(List<SelectItem> listDewey) {
        this.listDewey = listDewey;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    //  //</editor-fold>
    public void consultaTitulo() throws IOException {
        listTitulo = TituloFCD.listResultadoBusqueda(titNombre);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsTitulo.xhtml");
    }

    public void consultaModTitulo() throws IOException {
        listTitulo = TituloFCD.listResultadoBusqueda(titNombre);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResModTitulo.xhtml");
    }

    public void cargaDewey() {
        this.listDewey = DeweyFCD.listResultadoBusqueda();
    }

    public void insTitulo() {
        titulo.setTitCod(titCod);
        titulo.setTitNombre(titNombre);
        titulo.setTitTipo(titTipo);
        Dewey dewey = new Dewey();
        dewey.setDwCod(deweyCod);
        titulo.setTitDewey(dewey);

        boolean error = TituloFCD.insertaTitulo(titulo);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void selectTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public void modTitulo() {
        Dewey d = new Dewey();
       d.setDwCod(deweyCod);
        titulo.setTitDewey(d);
        boolean error = TituloFCD.updateTitulo(titulo, tituloOri);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void redirigirModTitulo() {
        this.tituloOri.setTitCod(titulo.getTitCod());
        this.tituloOri.setTitNombre(titulo.getTitNombre());
        this.tituloOri.setTitTipo(titulo.getTitTipo());

    }

}
