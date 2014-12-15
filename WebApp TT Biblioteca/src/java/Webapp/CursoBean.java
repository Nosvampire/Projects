/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CursoFCD;
import POJO.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "cursobean")
@SessionScoped
public class CursoBean {

    private String curCodigo;
    private String curDescripcion;
    private List<Curso> listCurso;

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
}
