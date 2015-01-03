/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.EditorialDAO;
import POJO.Editorial;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niko
 */
public class EditorialFCD {

    public static boolean insertEditorial(Editorial editorial) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = EditorialDAO.insertEditorial(conn, editorial);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean updateEditorial(Editorial editorial, Editorial ediOriginal) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = EditorialDAO.updateEditorial(conn, editorial, ediOriginal);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean deleteEditorial(Editorial editorial) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = EditorialDAO.deleteEditorial(conn, editorial);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static List<Editorial> selectEditorial() {
        Connection conn = new DBConnection().getConexion();
        List<Editorial> listEditorial = new ArrayList<>();
        listEditorial = EditorialDAO.listarEditorial(conn);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return listEditorial;
    }
}
