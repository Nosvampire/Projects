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

    public void insertarPais(){
        PaisFCD.insertaPais(pais);
        FacesMessage msg = new FacesMessage("Mdificación exitosa.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void consultarPais() throws IOException {
        listPais = PaisFCD.listPais();
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsPais.xhtml");
    }
}
