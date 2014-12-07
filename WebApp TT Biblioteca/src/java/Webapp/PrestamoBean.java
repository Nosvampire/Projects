/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import FCD.PrestamoFCD;
import POJO.Copia;
import POJO.Prestamo;
import POJO.Usuario;
import Util.DateTimeConverters;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Niko
 */
@ManagedBean(name = "prestamobean")
@SessionScoped
public class PrestamoBean {

    private List<Prestamo> listPrestamos;
    private int diasPrestmo;
    private Prestamo prestamo;
    private int rut;
    private String dv;

    public List<Prestamo> getListPrestamos() {
        return listPrestamos;
    }

    public void setListPrestamos(List<Prestamo> listPrestamos) {
        this.listPrestamos = listPrestamos;
    }

    public int getDiasPrestmo() {
        return diasPrestmo;
    }

    public void setDiasPrestmo(int diasPrestmo) {
        this.diasPrestmo = diasPrestmo;
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

    public void añadirPrestamo(Copia copia) {
        Date d = new Date();
        LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        date.plusDays(diasPrestmo);
        java.sql.Date sqlDateDevolucion = new java.sql.Date(DateTimeConverters.localDateToDate(date).getTime());
        Usuario usuario = new Usuario(rut, dv, null, null, null, null, null, null, null, 0, null);
        Prestamo prestamo = new Prestamo(usuario, copia, sqlDate, sqlDateDevolucion, 0, 0, null, "v");
        PrestamoFCD.insertPrestamo(prestamo);
    }
}
