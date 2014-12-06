/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Webapp;

import FCD.TituloFCD;
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
@ManagedBean(name = "titulobean")
@SessionScoped
public class TituloBean {
     private String titNombre;
     private List<Titulo> listTitulo;
     private Copia copia;
     
      //<editor-fold defaultstate="collapsed" desc="GETTER && SETTER">
   public String getTitNombre(){
        return titNombre;
       
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
     
     //  //</editor-fold>
   public void consultaTitulo() throws IOException{
   listTitulo = TituloFCD.listResultadoBusqueda(titNombre);
   FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsTitulo.xhtml");
   }
    
}
