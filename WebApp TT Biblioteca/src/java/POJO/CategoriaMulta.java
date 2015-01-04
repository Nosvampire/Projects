package POJO;

public class CategoriaMulta {

    private String camCod;
    private String camNombre;
    private String camDescripcion;
    private int camCantDiasPrestamo;
    private int camValorMultaDia;

    public CategoriaMulta() {
    }

    public CategoriaMulta(String camCod, String camNombre, String camDescripcion, int camCantDiasPrestamo, int camValorMultaDia) {
        this.camCod = camCod;
        this.camNombre = camNombre;
        this.camDescripcion = camDescripcion;
        this.camCantDiasPrestamo = camCantDiasPrestamo;
        this.camValorMultaDia = camValorMultaDia;
    }

    public String getCamCod() {
        return camCod;
    }

    public void setCamCod(String camCod) {
        this.camCod = camCod;
    }

    public String getCamNombre() {
        return camNombre;
    }

    public void setCamNombre(String camNombre) {
        this.camNombre = camNombre;
    }

    public String getCamDescripcion() {
        return camDescripcion;
    }

    public void setCamDescripcion(String camDescripcion) {
        this.camDescripcion = camDescripcion;
    }

    public int getCamCantDiasPrestamo() {
        return camCantDiasPrestamo;
    }

    public void setCamCantDiasPrestamo(int camCantDiasPrestamo) {
        this.camCantDiasPrestamo = camCantDiasPrestamo;
    }

    public int getCamValorMultaDia() {
        return camValorMultaDia;
    }

    public void setCamValorMultaDia(int camValorMultaDia) {
        this.camValorMultaDia = camValorMultaDia;
    }

}
