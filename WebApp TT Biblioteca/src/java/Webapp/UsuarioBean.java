package Webapp;

import FCD.UsuarioFCD;
import POJO.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuariobean")
@SessionScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> listUsuarios;
    private int rut;
    private String nombre = null;
    private String priApellido = null;
    private String secApellido = null;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSecApellido() {
        return secApellido;
    }

    public void setSecApellido(String secApellido) {
        this.secApellido = secApellido;
    }

    public void consultarUsuarioNombre() throws IOException {
        listUsuarios = UsuarioFCD.buscarUsuarioNombre(nombre, priApellido, secApellido);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsUsuario.xhtml");
    }
    public void consultarUsuarioRut() throws IOException{
        listUsuarios = UsuarioFCD.buscarUsuarioRut(rut);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsUsuario.xhtml");
    }
    
}