package Webapp;

import FCD.PaisFCD;
import POJO.Pais;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "paisbean")
@SessionScoped
public class PaisBean {

    private String codPais;
    private String nomPais;
    private List<Pais> listPais;
    private Pais pais;
    private Pais paisOri;

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public List<Pais> getListPais() {
        return listPais;
    }

    public void setListPais(List<Pais> listPais) {
        this.listPais = listPais;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void consultarPais() throws IOException {
        listPais = PaisFCD.listPais();

    }

    public void insPais() {
        pais.setCodPais(codPais);
        pais.setNomPais(nomPais);

        boolean error = PaisFCD.insertaPais(pais);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void selectPais(Pais pais) {
        this.pais = pais;
    }
      public void redirigirModPais() {
        this.paisOri.setCodPais(pais.getCodPais());
        this.paisOri.setNomPais(pais.getNomPais());
        
    }
      
    public void modPais() {

        boolean error = PaisFCD.updatePais(pais, paisOri);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
        public void elimPais() {
        boolean error = PaisFCD.deletePais(pais);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
