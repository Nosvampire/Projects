/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.CopiaFCD;
import FCD.PrestamoFCD;
import FCD.UsuarioFCD;
import POJO.Condicion;
import POJO.Copia;
import POJO.Prestamo;
import POJO.Usuario;
import Util.DateTimeConverters;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "prestamobean")
@SessionScoped
public class PrestamoBean {

    private List<Prestamo> listPrestamos;
    private int diasPrestamo;
    private Prestamo prestamo;
    private int rut;
    private String dv;
    private Date fechaInicio;
    private Date fechaTermino;

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    public int getDiasPrestmo() {
        return diasPrestamo;
    }

    public void setDiasPrestmo(int diasPrestmo) {
        this.diasPrestamo = diasPrestmo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public void añadirPrestamo(Copia copia) {
        boolean b = UsuarioFCD.checkEstadoUsuario(rut, dv);
        if (b == true) {
            Date d = new Date();
            LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            LocalDate dateDevolucion = date.plusDays(diasPrestamo);
            java.sql.Date sqlDateDevolucion = new java.sql.Date(DateTimeConverters.localDateToDate(dateDevolucion).getTime());
            Usuario usuario = new Usuario(rut, dv, null, null, null, null, null, null, null, 0, null);
            Prestamo prestamo = new Prestamo(usuario, copia, sqlDate, sqlDateDevolucion, 0, 0, null, "V");
            boolean error = PrestamoFCD.insertPrestamo(prestamo);
            if (error == false) {
                Condicion condicion = new Condicion();
                condicion.setConCodigo("P");
                condicion.setConDescripcion("Prestado");
                copia.setCondicion(condicion);
                CopiaFCD.modificarCopia(copia);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Prestamo Agregado! ", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else if (error == true) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Prestamo Duplicado ", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario Deshabilitado ", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        diasPrestamo = 0;
        rut = 0;
        dv = null;

    }

    public void consultarPrestamo() throws IOException {
        java.sql.Date fechaInicioSql = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date fechaTerminoSql = new java.sql.Date(fechaTermino.getTime());

        this.listPrestamos = PrestamoFCD.consultarPrestamo(fechaInicioSql, fechaTerminoSql, rut);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ResConsPrestamo.xhtml");
    }
}
