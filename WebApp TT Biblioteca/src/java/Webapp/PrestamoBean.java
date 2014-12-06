/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Webapp;

import POJO.Copia;
import POJO.Prestamo;
import java.util.Date;
import java.text.SimpleDateFormat;
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

    public void añadirPrestamo(Copia copia) {
        Date d = new Date();
        LocalDate date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        date.plusDays(diasPrestmo);
        prestamo.setCopia(copia);
        prestamo.setPreFecha(sqlDate);
    }
}
