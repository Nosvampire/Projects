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

/**
 *
 * @author Niko
 */
public class PrestamoFCD {

    public static void insertPrestamo(Prestamo prestamo) {
        Connection conn = DBConnection.getConexion();
        PrestamoDAO.insertPrestamo(conn, prestamo);
    }

}
