package POJO;

public class Dewey {

    private int dwCod;
    private int dwCodSuperior;
    private String dwCategoria;

    public Dewey() {
    }

    public Dewey(int dwCod, int dwCodSuperior, String dwCategoria) {
        this.dwCod = dwCod;
        this.dwCodSuperior = dwCodSuperior;
        this.dwCategoria = dwCategoria;
    }

    public int getDwCod() {
        return dwCod;
    }

    public void setDwCod(int dwCod) {
        this.dwCod = dwCod;
    }

    public int getDwCodSuperior() {
        return dwCodSuperior;
    }

    public void setDwCodSuperior(int dwCodSuperior) {
        this.dwCodSuperior = dwCodSuperior;
    }

    public String getDwCategoria() {
        return dwCategoria;
    }

    public void setDwCategoria(String dwCategoria) {
        this.dwCategoria = dwCategoria;
    }
}
