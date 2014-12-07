/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CopiaFCD;
import POJO.Copia;
import POJO.Titulo;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    public void consultarCopia(Titulo titulo) throws IOException {
        listCopia = CopiaFCD.listResultadoBusqueda(titulo.getTitCod());
        for (int i = 0; i < listCopia.size(); i++) {
            for (int j = 0; j < listCopia.get(i).getListAutores().size(); j++) {
                if (listCopia.get(i).getAutores() != null) {
                    listCopia.get(i).setAutores(listCopia.get(i).getAutores() + listCopia.get(i).getListAutores().get(j).getAutNombre() + " " + listCopia.get(i).getListAutores().get(j).getAutNombre() + "; ");
                } else {
                    listCopia.get(i).setAutores("" + listCopia.get(i).getListAutores().get(j).getAutNombre() + " " + listCopia.get(i).getListAutores().get(j).getAutApellido() + ";");
                }
            }
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsCopia.xhtml");
    }
}
