/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.AutorDAO;
import POJO.Autor;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 */
public class AutorFCD {

    public static List<Autor> listResultadoBusqueda(String nombres, String apellidos) {
        Connection conexion = DBConnection.getConexion();
        List<Autor> listResultadoBusqueda = new ArrayList<Autor>();
        listResultadoBusqueda = AutorDAO.listarAutor(conexion, nombres, apellidos);
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResultadoBusqueda;
    }

    public static void insertaAutor(String nombre, Autor autor) {
        Connection conexion = DBConnection.getConexion();

        AutorDAO.insertAutor(conexion, autor);

        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<Autor> listAutoresPorCodCopia(int codCopia) {
        Connection conn = DBConnection.getConexion();
        List<Autor> listAutors = new ArrayList<>();
        listAutors = AutorDAO.listAutoresPorCodCopia(conn, codCopia);
        return listAutors;
    }

}
