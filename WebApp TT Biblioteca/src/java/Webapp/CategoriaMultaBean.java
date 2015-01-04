/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CategoriaMultaFCD;
import POJO.CategoriaMulta;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "categoriamultabean")
@SessionScoped
public class CategoriaMultaBean {

    private String camNombre;
    private List<CategoriaMulta> listCategoria;
    private CategoriaMulta categoriaMulta = new CategoriaMulta();
    private CategoriaMulta categoriaMultaOri = new CategoriaMulta();
    private String camCod;
    private String camDescripcion;
    private int camCantDiasPrestamo;
    private int valorMulta;

    public String getCamNombre() {
        return camNombre;
    }

    public void setCamNombre(String camNombre) {
        this.camNombre = camNombre;
    }

    public List<CategoriaMulta> getListCategoria() {
        return listCategoria;
    }

    public void setListCategoria(List<CategoriaMulta> listCategoria) {
        this.listCategoria = listCategoria;
    }

    public CategoriaMulta getCategoriaMulta() {
        return categoriaMulta;
    }

    public void setCategoriaMulta(CategoriaMulta categoriaMulta) {
        this.categoriaMulta = categoriaMulta;
    }

    public CategoriaMulta getCategoriaMultaOri() {
        return categoriaMultaOri;
    }

    public void setCategoriaMultaOri(CategoriaMulta categoriaMultaOri) {
        this.categoriaMultaOri = categoriaMultaOri;
    }

    public String getCamCod() {
        return camCod;
    }

    public void setCamCod(String camCod) {
        this.camCod = camCod;
    }

    public String getCamDescripcion() {
        return camDescripcion;
    }

    public void setCamDescripcion(String camDescripcion) {
        this.camDescripcion = camDescripcion;
    }

    public int getCamCantDiasPrestamo() {
        return camCantDiasPrestamo;
    }

    public void setCamCantDiasPrestamo(int camCantDiasPrestamo) {
        this.camCantDiasPrestamo = camCantDiasPrestamo;
    }

    public int getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(int valorMulta) {
        this.valorMulta = valorMulta;
    }
    
    public void consultarCategoriaMulta(){
        listCategoria = CategoriaMultaFCD.selectCategoriaMulta();
    }

    public void elimCategoriaMulta() {
        boolean error = CategoriaMultaFCD.deleteCategoriaMulta(categoriaMulta);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void insCategoriaMulta() {
        categoriaMulta.setCamCod(camCod);
        categoriaMulta.setCamNombre(camNombre);
        categoriaMulta.setCamDescripcion(camDescripcion);
        categoriaMulta.setCamCantDiasPrestamo(camCantDiasPrestamo);
        categoriaMulta.setCamValorMultaDia(valorMulta);

        boolean error = CategoriaMultaFCD.insertCategoriaMulta(categoriaMulta);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void modCategoriaMulta(){
        boolean error = CategoriaMultaFCD.updateCategoriaMulta(categoriaMulta, categoriaMultaOri);
        if(error == true){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en la Modificacion", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            FacesMessage msg = new FacesMessage("Modificacion Exitosa.","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void selectCategoriaMulta(CategoriaMulta c) {
        this.categoriaMulta = c;
    }
    
    public void redirigirModCategoriaMulta(){
        this.categoriaMultaOri.setCamCod(categoriaMulta.getCamCod());
        this.categoriaMultaOri.setCamNombre(categoriaMulta.getCamNombre());
        this.categoriaMultaOri.setCamDescripcion(categoriaMulta.getCamDescripcion());
        this.categoriaMultaOri.setCamCantDiasPrestamo(categoriaMulta.getCamCantDiasPrestamo());
        this.categoriaMultaOri.setCamValorMultaDia(categoriaMulta.getCamValorMultaDia());   
    }
}