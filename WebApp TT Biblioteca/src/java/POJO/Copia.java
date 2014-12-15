package POJO;

import java.util.List;
import java.util.Set;

public class Copia {

    private int copTitulo;
    private String copNombre;
    private int copCod;
    private Editorial editorial;
    private int copEdicion;
    private int copPaginas;
    private String copTipo;
    private CategoriaMulta categoriaMulta;
    private Condicion condicion;
    private String copYearPublicacion;
    private String copISBN;
    private List<Autor> listAutores;
    private String autores;

    public Copia() {
    }

    public Copia(int copTitulo, String copNombre, int copCod, Editorial editorial, int copEdicion, int copPaginas, String copTipo, CategoriaMulta categoriaMulta, Condicion condicion, String copYearPublicacion, String copISBN, List<Autor> listAutores, String autores) {
        this.copTitulo = copTitulo;
        this.copNombre = copNombre;
        this.copCod = copCod;
        this.editorial = editorial;
        this.copEdicion = copEdicion;
        this.copPaginas = copPaginas;
        this.copTipo = copTipo;
        this.categoriaMulta = categoriaMulta;
        this.condicion = condicion;
        this.copYearPublicacion = copYearPublicacion;
        this.copISBN = copISBN;
        this.listAutores = listAutores;
        this.autores = autores;
    }

    public int getCopTitulo() {
        return copTitulo;
    }

    public void setCopTitulo(int copTitulo) {
        this.copTitulo = copTitulo;
    }

    public String getCopNombre() {
        return copNombre;
    }

    public void setCopNombre(String copNombre) {
        this.copNombre = copNombre;
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

    public List<Autor> getListAutores() {
        return listAutores;
    }

    public void setListAutores(List<Autor> listAutores) {
        this.listAutores = listAutores;
    }

    public String getAutores() {

        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

}
