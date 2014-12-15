/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FCD;

import Connection.DBConnection;
import DAO.CategoriaMultaDAO;
import DAO.DeweyDAO;
import POJO.CategoriaMulta;
import POJO.Dewey;
import java.sql.Connection;

/**
 *
 * @author Niko
 */
public class DeweyFCD {
      public static void insertDewey(Dewey dewey) {
        Connection conn = DBConnection.getConexion();
        DeweyDAO.insertDewey(conn, dewey);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void updateDewey(Dewey dewey) {
        Connection conn = DBConnection.getConexion();
        DeweyDAO.updateDewey(conn, dewey);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void deleteDewey(Dewey dewey) {
        Connection conn = DBConnection.getConexion();
        DeweyDAO.deleteDewey(conn, dewey);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}
