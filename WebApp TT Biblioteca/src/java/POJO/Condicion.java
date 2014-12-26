package POJO;

public class Condicion {

    private String conCodigo;
    private String conDescripcion;

    public Condicion() {
    }

    public Condicion(String conCodigo, String conDescripcion) {
        this.conCodigo = conCodigo;
        this.conDescripcion = conDescripcion;
    }

    public String getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(String conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }
    
}
