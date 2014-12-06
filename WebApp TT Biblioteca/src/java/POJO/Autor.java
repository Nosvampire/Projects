package POJO;

public class Autor {

    private int autCod;
    private String autNombre;
    private String autApellido;
    private String autSeudonimo;
    private Pais autPais;

    public Autor() {
    }

    public Autor(int autCod, String autNombre, String autApellido, String autSeudonimo, Pais autPais) {
        this.autCod = autCod;
        this.autNombre = autNombre;
        this.autApellido = autApellido;
        this.autSeudonimo = autSeudonimo;
        this.autPais = autPais;
    }

    public int getAutCod() {
        return autCod;
    }

    public void setAutCod(int autCod) {
        this.autCod = autCod;
    }

    public String getAutNombre() {
        return autNombre;
    }

    public void setAutNombre(String autNombre) {
        this.autNombre = autNombre;
    }

    public String getAutApellido() {
        return autApellido;
    }

    public void setAutApellido(String autApellido) {
        this.autApellido = autApellido;
    }

    public String getAutSeudonimo() {
        return autSeudonimo;
    }

    public void setAutSeudonimo(String autSeudonimo) {
        this.autSeudonimo = autSeudonimo;
    }

    public Pais getAutPais() {
        return autPais;
    }

    public void setAutPais(Pais autPais) {
        this.autPais = autPais;
    }
    

}
