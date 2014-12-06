/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.AutorFCD;
import FCD.PaisFCD;
import POJO.Autor;
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
@ManagedBean(name = "autoresbean")
@SessionScoped
public class AutoresBean {

    private String codPais;
    private String nombre;
    private String Apellido;
    private List<Autor> listAutor;
    private String seudonimo;
    private List<SelectItem> listPais;
    private Autor autor;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public List<Autor> getListAutor() {
        return listAutor;
    }

    public void setListAutor(List<Autor> listAutor) {
        this.listAutor = listAutor;
    }

    public List<SelectItem> getListPais() {
        return listPais;
    }

    public void setListPais(List<SelectItem> listPais) {
        this.listPais = listPais;
    }

    public void consultarAutores() throws IOException {
        listAutor = AutorFCD.listResultadoBusqueda(nombre, Apellido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsAutor.xhtml");
    }

    public void redirigeModificarAutor() {
      
        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void redirigeInsertarAutor() {
        
        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void insertarAutor() {
        AutorFCD.insertaAutor(nombre, autor);
        FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
