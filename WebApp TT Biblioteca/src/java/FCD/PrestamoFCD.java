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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 */
public class PrestamoFCD {

    public static void insertPrestamo(Prestamo prestamo) {
        Connection conn = DBConnection.getConexion();
        PrestamoDAO.insertPrestamo(conn, prestamo);
          try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
