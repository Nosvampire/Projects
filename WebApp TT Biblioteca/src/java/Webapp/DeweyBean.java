/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.DeweyFCD;
import POJO.Dewey;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "deweybean")
@SessionScoped
public class DeweyBean {

    private int dwCod;
    private String dwCategoria;
    private Dewey dewey = new Dewey();
    private Dewey deweyOri = new Dewey();
    private List<Dewey> listDwey;

    public int getDwCod() {
        return dwCod;
    }

    public void setDwCod(int dwCod) {
        this.dwCod = dwCod;
    }

    public String getDwCategoria() {
        return dwCategoria;
    }

    public void setDwCategoria(String dwCategoria) {
        this.dwCategoria = dwCategoria;
    }

    public Dewey getDewey() {
        return dewey;
    }

    public void setDewey(Dewey dewey) {
        this.dewey = dewey;
    }

    public Dewey getDeweyOri() {
        return deweyOri;
    }

    public void setDeweyOri(Dewey deweyOri) {
        this.deweyOri = deweyOri;
    }

    public void selectDewey(Dewey dewey) {
        this.dewey = dewey;
    }

    public List<Dewey> getListDwey() {
        return listDwey;
    }

    public void setListDwey(List<Dewey> listDwey) {
        this.listDwey = listDwey;
    }

    public void cargaDewey() {
        listDwey = DeweyFCD.listDewey();
    }

    public void insDewey() {
        Dewey dewey = new Dewey();
        dewey.setDwCod(dwCod);
        dewey.setDwCategoria(dwCategoria);
        boolean error = DeweyFCD.insertDewey(dewey);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void redirigirModDewey() {
        this.deweyOri.setDwCod(dewey.getDwCod());
        this.deweyOri.setDwCategoria(dewey.getDwCategoria());
    }

    public void modDewey() {

        boolean error = DeweyFCD.updateDewey(dewey, deweyOri);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }
        public void elimDewey() {
        boolean error = DeweyFCD.deleteDewey(dewey);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
