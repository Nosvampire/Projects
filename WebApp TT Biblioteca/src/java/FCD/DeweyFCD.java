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

    public static boolean insertDewey(Dewey dewey) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = DeweyDAO.insertDewey(conn, dewey);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean updateDewey(Dewey dewey, Dewey deweyOri) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = DeweyDAO.updateDewey(conn, dewey, deweyOri);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean deleteDewey(Dewey dewey) {
        boolean b ;
        Connection conn = DBConnection.getConexion();
      b=  DeweyDAO.deleteDewey(conn, dewey);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
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
