/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.UsuarioFCD;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "loginbean")
@SessionScoped
public class LoginBean {

    private int usuario;
    private String contraseña;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void login() throws IOException {
        String tipoUsuario = UsuarioFCD.checkTipoUsuario(usuario, contraseña);
        if ("".equals(tipoUsuario)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en datos de Login! ", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            contraseña = "";
        } else if ("ADM".equals(tipoUsuario) || "BIB".equals(tipoUsuario)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else if ("ALU".equals(tipoUsuario) || "FUN".equals(tipoUsuario) || "PRO".equals(tipoUsuario)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("indexUsuario.xhtml");
        }
    }
}
