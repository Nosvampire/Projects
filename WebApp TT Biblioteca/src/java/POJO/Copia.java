package POJO;

import java.util.HashSet;
import java.util.Set;

public class Copia {

    private int copTitulo;
    private int copCod;
    private Editorial editorial;
    private int copEdicion;
    private int copPaginas;
    private String copTipo;
    private CategoriaMulta categoriaMulta;
    private Condicion condicion;
    private String copYearPublicacion;
    private String copISBN;
    private Set autores = new HashSet(0);

    public Copia() {
    }

    public Copia(int copTitulo, int copCod, Editorial editorial, int copEdicion, int copPaginas, String copTipo, CategoriaMulta categoriaMulta, Condicion condicion, String copYearPublicacion, String copISBN) {
        this.copTitulo = copTitulo;
        this.copCod = copCod;
        this.editorial = editorial;
        this.copEdicion = copEdicion;
        this.copPaginas = copPaginas;
        this.copTipo = copTipo;
        this.categoriaMulta = categoriaMulta;
        this.condicion = condicion;
        this.copYearPublicacion = copYearPublicacion;
        this.copISBN = copISBN;
    }

    public int getCopTitulo() {
        return copTitulo;
    }

    public void setCopTitulo(int copTitulo) {
        this.copTitulo = copTitulo;
    }

    public int getCopCod() {
        return copCod;
    }

    public void setCopCod(int copCod) {
        this.copCod = copCod;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public int getCopEdicion() {
        return copEdicion;
    }

    public void setCopEdicion(int copEdicion) {
        this.copEdicion = copEdicion;
    }

    public int getCopPaginas() {
        return copPaginas;
    }

    public void setCopPaginas(int copPaginas) {
        this.copPaginas = copPaginas;
    }

    public String getCopTipo() {
        return copTipo;
    }

    public void setCopTipo(String copTipo) {
        this.copTipo = copTipo;
    }

    public CategoriaMulta getCategoriaMulta() {
        return categoriaMulta;
    }

    public void setCategoriaMulta(CategoriaMulta categoriaMulta) {
        this.categoriaMulta = categoriaMulta;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public String getCopYearPublicacion() {
        return copYearPublicacion;
    }

    public void setCopYearPublicacion(String copYearPublicacion) {
        this.copYearPublicacion = copYearPublicacion;
    }

    public String getCopISBN() {
        return copISBN;
    }

    public void setCopISBN(String copISBN) {
        this.copISBN = copISBN;
    }

    public Set getAutores() {
        return autores;
    }

    public void setAutores(Set autores) {
        this.autores = autores;
    }

}
