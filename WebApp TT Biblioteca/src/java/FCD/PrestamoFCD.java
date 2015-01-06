/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.PrestamoDAO;
import POJO.Prestamo;
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
public class PrestamoFCD {

    public static boolean insertPrestamo(Prestamo prestamo) {
        boolean b = false;
        Connection conn = DBConnection.getConexion();
        b = PrestamoDAO.insertPrestamo(conn, prestamo);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public static List<Prestamo> consultarPrestamo(java.sql.Date fechaInicio, java.sql.Date fechaTermino, int rut) {
        Connection conn = DBConnection.getConexion();
        List<Prestamo> listResultado = new ArrayList<>();
        listResultado = PrestamoDAO.listarPrestamo(conn, fechaInicio, fechaTermino, rut);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResultado;
    }
      public static boolean updatePrestamo(Prestamo prestamo, Prestamo presOriginal) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = PrestamoDAO.updatePrestamo(conn, prestamo, presOriginal);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }
}
