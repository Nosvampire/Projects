/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FCD;

import Connection.DBConnection;
import DAO.DeweyDAO;
import POJO.Dewey;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

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
      public static List<SelectItem> listResultadoBusqueda() {
        Connection conn = DBConnection.getConexion();
        ArrayList<SelectItem> r = new ArrayList<SelectItem>();
        for (Dewey rap : DeweyFCD.listDewey()) {
            r.add(new SelectItem(rap.getDwCod(), rap.getDwCategoria()));
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static List<Dewey> listDewey() {
        List<Dewey> listAccion;
        Connection conexion = DBConnection.getConexion();
        listAccion = DeweyDAO.listarDewey(conexion);
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error [DweyFCD][listDwey][SQLException]: " + e.getMessage());
        }
        return listAccion;
    }
}
