package POJO;

import java.sql.Date;

public class Prestamo {

    private Usuario usuario;
    private Copia copia;
    private Date preFecha;
    private Date preFechaDevolucion;
    private int preValorCancelado;
    private int preMulta;
    private Date preFechaDevEfectiva;
    private String preVigencia;

    public Prestamo() {
    }

    public Prestamo(Usuario usuario, Copia copia, Date preFecha, Date preFechaDevolucion, int preValorCancelado, int preMulta, Date preFechaDevEfectiva, String preVigencia) {
        this.usuario = usuario;
        this.copia = copia;
        this.preFecha = preFecha;
        this.preFechaDevolucion = preFechaDevolucion;
        this.preValorCancelado = preValorCancelado;
        this.preMulta = preMulta;
        this.preFechaDevEfectiva = preFechaDevEfectiva;
        this.preVigencia = preVigencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Date getPreFecha() {
        return preFecha;
    }

    public void setPreFecha(Date preFecha) {
        this.preFecha = preFecha;
    }

    public Date getPreFechaDevolucion() {
        return preFechaDevolucion;
    }

    public void setPreFechaDevolucion(Date preFechaDevolucion) {
        this.preFechaDevolucion = preFechaDevolucion;
    }

    public int getPreValorCancelado() {
        return preValorCancelado;
    }

    public void setPreValorCancelado(int preValorCancelado) {
        this.preValorCancelado = preValorCancelado;
    }

    public int getPreMulta() {
        return preMulta;
    }

    public void setPreMulta(int preMulta) {
        this.preMulta = preMulta;
    }

    public Date getPreFechaDevEfectiva() {
        return preFechaDevEfectiva;
    }

    public void setPreFechaDevEfectiva(Date preFechaDevEfectiva) {
        this.preFechaDevEfectiva = preFechaDevEfectiva;
    }

    public String getPreVigencia() {
        return preVigencia;
    }

    public void setPreVigencia(String preVigencia) {
        this.preVigencia = preVigencia;
    }
}
