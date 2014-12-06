package POJO;

public class Titulo {

    private int titCod;
    private String titNombre;
    private String titTipo;
    private Dewey titDewey;

    public Titulo() {
    }

    public Titulo(int titCod, String titNombre, String titTipo, Dewey titDewey) {
        this.titCod = titCod;
        this.titNombre = titNombre;
        this.titTipo = titTipo;
        this.titDewey = titDewey;
    }

    public int getTitCod() {
        return titCod;
    }

    public void setTitCod(int titCod) {
        this.titCod = titCod;
    }

    public String getTitNombre() {
        return titNombre;
    }

    public void setTitNombre(String titNombre) {
        this.titNombre = titNombre;
    }

    public String getTitTipo() {
        return titTipo;
    }

    public void setTitTipo(String titTipo) {
        this.titTipo = titTipo;
    }

    public Dewey getTitDewey() {
        return titDewey;
    }

    public void setTitDewey(Dewey titDewey) {
        this.titDewey = titDewey;
    }

}
