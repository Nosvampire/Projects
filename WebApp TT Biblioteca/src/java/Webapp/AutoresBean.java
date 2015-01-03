/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.AutorFCD;
import FCD.EditorialFCD;
import FCD.PaisFCD;
import POJO.Autor;
import POJO.Pais;
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
    private String nombre = "";
    private String Apellido = "";
    private List<Autor> listAutor;
    private String seudonimo = "";
    private List<SelectItem> listPais;
    private Autor autor = new Autor();
    private Autor autorOri = new Autor();
    private Pais pais = new Pais();

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

    public void consultarAutoresMod() throws IOException {
        listAutor = AutorFCD.listResultadoBusqueda(nombre, Apellido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResModAutor.xhtml");
    }

    public void consultarAutoresElim() throws IOException {
        listAutor = AutorFCD.listResultadoBusqueda(nombre, Apellido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsElimAutor.xhtml");
    }

    public void redirigeModificarAutor() {

        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void redirigeInsertarAutor() {

        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void insertarPais() {
        autor.setAutNombre(nombre);
        autor.setAutApellido(Apellido);
        autor.setAutSeudonimo(seudonimo);

        this.listAutor = AutorFCD.listResultadoBusqueda("", "");
        autor.setAutCod(listAutor.size() + 1);

        pais.setCodPais(codPais);
        List<Pais> lPais = PaisFCD.listPais();
        for (int i = 0; i < lPais.size(); i++) {
            if (lPais.get(i).getCodPais() == codPais) {
                pais.setNomPais(lPais.get(i).getNomPais());
            }
        }
        autor.setAutPais(pais);
        boolean error = AutorFCD.insertAutor(autor);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void selectAutor(Autor a) {
        this.autor = a;
    }

    public void elimAutor() {
        boolean error = AutorFCD.deleteAutor(autor);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void redirigirModAutor() {
        this.autorOri.setAutApellido(autor.getAutApellido());
        this.autorOri.setAutNombre(autor.getAutNombre());
        this.autorOri.setAutCod(autor.getAutCod());
        this.autorOri.setAutSeudonimo(autor.getAutSeudonimo());

     autorOri.setAutPais(autor.getAutPais());
    }

    public void modAutor() {
        Pais pais2 = new Pais();
        List<Pais> lPais = PaisFCD.listPais();
        for (int i = 0; i < lPais.size(); i++) {
            if (lPais.get(i).getCodPais().equals(codPais)) {
                pais2.setNomPais(lPais.get(i).getNomPais());
            }
        }
        pais2.setCodPais(codPais);
        autor.setAutPais(pais2);
        boolean error = AutorFCD.updateAutor(autor, autorOri);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

}
