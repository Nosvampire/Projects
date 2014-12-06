package POJO;

public class Curso {

    private String curCodigo;
    private String curDescripcion;

    public Curso() {
    }

    public Curso(String curCodigo, String curDescripcion) {
        this.curCodigo = curCodigo;
        this.curDescripcion = curDescripcion;
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

}
