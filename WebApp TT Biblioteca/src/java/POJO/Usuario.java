package POJO;

public class Usuario {

    private int usrRut;
    private String usrDv;
    private String usrNombres;
    private String usrPriApellido;
    private String usrSecApellido;
    private String usrFono;
    private String usrTipoCuenta;
    private String usrPass;
    private String usrEstado;
    private int usrMulta;
    private Curso curso;

    public Usuario() {
    }

    public Usuario(int usrRut, String usrDv, String usrNombres, String usrPriApellido, String usrSecApellido, String usrFono, String usrTipoCuenta, String usrPass, String usrEstado, int usrMulta, Curso curso) {
        this.usrRut = usrRut;
        this.usrDv = usrDv;
        this.usrNombres = usrNombres;
        this.usrPriApellido = usrPriApellido;
        this.usrSecApellido = usrSecApellido;
        this.usrFono = usrFono;
        this.usrTipoCuenta = usrTipoCuenta;
        this.usrPass = usrPass;
        this.usrEstado = usrEstado;
        this.usrMulta = usrMulta;
        this.curso = curso;
    }

    public int getUsrRut() {
        return usrRut;
    }

    public void setUsrRut(int usrRut) {
        this.usrRut = usrRut;
    }

    public String getUsrDv() {
        return usrDv;
    }

    public void setUsrDv(String usrDv) {
        this.usrDv = usrDv;
    }

    public String getUsrNombres() {
        return usrNombres;
    }

    public void setUsrNombres(String usrNombres) {
        this.usrNombres = usrNombres;
    }

    public String getUsrPriApellido() {
        return usrPriApellido;
    }

    public void setUsrPriApellido(String usrPriApellido) {
        this.usrPriApellido = usrPriApellido;
    }

    public String getUsrSecApellido() {
        return usrSecApellido;
    }

    public void setUsrSecApellido(String usrSecApellido) {
        this.usrSecApellido = usrSecApellido;
    }

    public String getUsrFono() {
        return usrFono;
    }

    public void setUsrFono(String usrFono) {
        this.usrFono = usrFono;
    }

    public String getUsrTipoCuenta() {
        return usrTipoCuenta;
    }

    public void setUsrTipoCuenta(String usrTipoCuenta) {
        this.usrTipoCuenta = usrTipoCuenta;
    }

    public String getUsrPass() {
        return usrPass;
    }

    public void setUsrPass(String usrPass) {
        this.usrPass = usrPass;
    }

    public String getUsrEstado() {
        return usrEstado;
    }

    public void setUsrEstado(String usrEstado) {
        this.usrEstado = usrEstado;
    }

    public int getUsrMulta() {
        return usrMulta;
    }

    public void setUsrMulta(int usrMulta) {
        this.usrMulta = usrMulta;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
