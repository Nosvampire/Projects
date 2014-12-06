/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CopiaFCD;
import POJO.Copia;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "copiabean")
@SessionScoped
public class CopiaBean {

    private String copTitulo;
    private int copCod;
    private List<Copia> listCopia;

    public String getCopTitulo() {
        return copTitulo;
    }

    public void setCopTitulo(String copTitulo) {
        this.copTitulo = copTitulo;
    }

    public int getCopCod() {
        return copCod;
    }

    public void setCopCod(int copCod) {
        this.copCod = copCod;
    }

    public List<Copia> getListCopia() {
        return listCopia;
    }

    public void setListCopia(List<Copia> listCopia) {
        this.listCopia = listCopia;
    }

    public void consultarCopia() {
        listCopia = CopiaFCD.listResultadoBusqueda(copCod, copTitulo);
    }
}