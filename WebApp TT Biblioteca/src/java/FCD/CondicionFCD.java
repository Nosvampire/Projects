/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.CondicionDAO;
import POJO.Condicion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niko
 */
public class CondicionFCD {

    public static boolean insertCondicion(Condicion condicion) {
        boolean b = false;
        Connection conn = DBConnection.getConexion();
        b = CondicionDAO.insertCondicion(conn, condicion);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean updateCondicion(Condicion condicion, Condicion conOriginal) {
        boolean b = false;
        Connection conn = DBConnection.getConexion();
        b = CondicionDAO.updateCondicion(conn, condicion, conOriginal);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean deleteCondicion(Condicion condicion) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = CondicionDAO.deleteCondicion(conn, condicion);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static List<Condicion> selectCondicion() {
        Connection conn = DBConnection.getConexion();
        List<Condicion> listCondicion = new ArrayList<>();
        listCondicion = CondicionDAO.listarCondicion(conn);
        return listCondicion;
    }
}
