/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FCD;

import Connection.DBConnection;
import DAO.CondicionDAO;
import DAO.EditorialDAO;
import POJO.Condicion;
import POJO.Editorial;
import java.sql.Connection;

/**
 *
 * @author Niko
 */
public class CondicionFCD {
     public static void insertCondicion(Condicion condicion) {
            Connection conn = DBConnection.getConexion();
            CondicionDAO.insertCondicion(conn, condicion);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        public static void updateCondicion(Condicion condicion) {
            Connection conn = DBConnection.getConexion();
            CondicionDAO.updateCondicion(conn, condicion);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        public static void deleteCondicion(Condicion condicion) {
            Connection conn = DBConnection.getConexion();
            CondicionDAO.deleteCondicion(conn, condicion);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
}