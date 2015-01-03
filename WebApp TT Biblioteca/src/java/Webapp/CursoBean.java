/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CursoFCD;
import POJO.Curso;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "cursobean")
@SessionScoped
public class CursoBean {

    private Curso curso = new Curso();
    private Curso curOriginal = new Curso();
    private String curCodigo;
    private String curDescripcion;
    private List<Curso> listCurso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(String curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurDescripcion() {
        return curDescripcion;
    }

    public void setCurDescripcion(String curDescripcion) {
        this.curDescripcion = curDescripcion;
    }

    public List<Curso> getListCurso() {
        return listCurso;
    }

    public void setListCurso(List<Curso> listCurso) {
        this.listCurso = listCurso;
    }

    public void consultarCurso() {
        listCurso = CursoFCD.listResultadoBusqueda();
    }

    public void selectCondicion(Curso c) {
        this.curso = c;

    }

    public void insCondicion() {
        Curso curso = new Curso(curCodigo, curDescripcion);
        boolean error = CursoFCD.insertCurso(curso);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la inserción", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Inserción exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void redirigirModCurso() {
        this.curOriginal.setCurCodigo(curso.getCurCodigo());
        this.curOriginal.setCurDescripcion(curso.getCurDescripcion());
    }

    public void modCurso() {

        boolean error = CursoFCD.updateCurso(curso, curOriginal);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la modificación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Modificación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void elimCurso() {
        boolean error = CursoFCD.deleteCurso(curso);
        if (error == true) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la eliminación", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage msg = new FacesMessage("Eliminación exitosa.", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
