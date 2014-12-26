/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CondicionFCD;
import POJO.Condicion;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "condicionbean")
@SessionScoped
public class CondicionBean {

    private Condicion condicion = new Condicion();
    private String codigo;
    private String descripcion;
    private List<Condicion> listCondicion;
    private Condicion conOriginal = new Condicion();

    public List<Condicion> getListCondicion() {
        return listCondicion;
    }

    public void setListCondicion(List<Condicion> listCondicion) {
        this.listCondicion = listCondicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void consultaCondicion() {
        listCondicion = CondicionFCD.selectCondicion();
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public void insCondicion() {

        Condicion condicion = new Condicion(codigo, descripcion);

        boolean error = CondicionFCD.insertCondicion(condicion);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void modCondicion() {

        boolean error = CondicionFCD.updateCondicion(condicion, conOriginal);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void redirigirModCondicion() {
        this.conOriginal.setConCodigo(condicion.getConCodigo());
        this.conOriginal.setConDescripcion(condicion.getConDescripcion());
        System.out.println("con " + condicion.getConCodigo() + " " + condicion.getConDescripcion());
    }

    public void selectCondicion(Condicion c) {
        this.condicion = c;

    }

    public void elimCondicion() {
        boolean error = CondicionFCD.deleteCondicion(condicion);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
