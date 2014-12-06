package POJO;

public class Editorial {

    private int ediCod;
    private String ediNombre;
    private Pais ediPais;

    public Editorial() {
    }

    public Editorial(int ediCod, String ediNombre, Pais ediPais) {
        this.ediCod = ediCod;
        this.ediNombre = ediNombre;
        this.ediPais = ediPais;
    }

    public int getEdiCod() {
        return ediCod;
    }

    public void setEdiCod(int ediCod) {
        this.ediCod = ediCod;
    }

    public String getEdiNombre() {
        return ediNombre;
    }

    public void setEdiNombre(String ediNombre) {
        this.ediNombre = ediNombre;
    }

    public Pais getEdiPais() {
        return ediPais;
    }

    public void setEdiPais(Pais ediPais) {
        this.ediPais = ediPais;
    }

}
