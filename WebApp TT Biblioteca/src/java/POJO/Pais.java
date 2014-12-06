package POJO;

public class Pais {

    private String codPais;
    private String nomPais;

    public Pais() {
    }

    public Pais(String codPais, String nomPais) {
        this.codPais = codPais;
        this.nomPais = nomPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }
}
