/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.EditorialFCD;
import FCD.PaisFCD;
import POJO.Editorial;
import POJO.Pais;
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
@ManagedBean(name = "editorialbean")
@SessionScoped
public class EditorialBean {

    private List<Editorial> listEditorial;
    private Editorial editorial = new Editorial();
    private Editorial ediOriginal = new Editorial();
    private int codigo;
    private String nombre;
    private String codPais;
    private List<SelectItem> listPais;
    private Pais pais = new Pais();

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Editorial> getListEditorial() {
        return listEditorial;
    }

    public void setListEditorial(List<Editorial> listEditorial) {
        this.listEditorial = listEditorial;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Editorial getEdiOriginal() {
        return ediOriginal;
    }

    public void setEdiOriginal(Editorial ediOriginal) {
        this.ediOriginal = ediOriginal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public List<SelectItem> getListPais() {
        return listPais;
    }

    public void setListPais(List<SelectItem> listPais) {
        this.listPais = listPais;
    }

    public void consultarEditorial() {
        listEditorial = EditorialFCD.selectEditorial();
        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void cargaPais() {
        this.listPais = PaisFCD.listResultadoBusqueda();
    }

    public void selectEditorial(Editorial edi) {
        this.editorial = edi;
    }

    public void insEditorial() {
        editorial.setEdiCod(codigo);
        editorial.setEdiNombre(nombre);
        pais.setCodPais(codPais);
        List<Pais> lPais = PaisFCD.listPais();
        for (int i = 0; i < lPais.size(); i++) {
            if (lPais.get(i).getCodPais() == codPais) {
                pais.setNomPais(lPais.get(i).getNomPais());
            }
        }
        editorial.setEdiPais(pais);
        boolean error = EditorialFCD.insertEditorial(editorial);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void redirigirModEditorial() {
        this.ediOriginal.setEdiCod(editorial.getEdiCod());
        this.ediOriginal.setEdiNombre(editorial.getEdiNombre());
        Pais pais2 = new Pais();
        List<Pais> lPais = PaisFCD.listPais();
        for (int i = 0; i < lPais.size(); i++) {
            if (lPais.get(i).getCodPais() == codPais) {
                pais2.setNomPais(lPais.get(i).getNomPais());
            }
        }
        pais2.setCodPais(codPais);
        this.ediOriginal.setEdiPais(pais2);
        editorial.setEdiPais(pais2);
    }

    public void modEditorial() {
        Pais pais2 = new Pais();
        List<Pais> lPais = PaisFCD.listPais();
        for (int i = 0; i < lPais.size(); i++) {
            if (lPais.get(i).getCodPais().equals(codPais)) {
                pais2.setNomPais(lPais.get(i).getNomPais());
            }
        }
        pais2.setCodPais(codPais);
        editorial.setEdiPais(pais2);
        boolean error = EditorialFCD.updateEditorial(editorial, ediOriginal);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void elimEditorial() {
        boolean error = EditorialFCD.deleteEditorial(editorial);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
