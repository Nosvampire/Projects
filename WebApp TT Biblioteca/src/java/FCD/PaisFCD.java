/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.PaisDAO;
import POJO.Pais;
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
public class PaisFCD {

    public static List<SelectItem> listResultadoBusqueda() {
        Connection conn = DBConnection.getConexion();
        ArrayList<SelectItem> r = new ArrayList<SelectItem>();
        for (Pais rap : PaisFCD.listPais()) {
            r.add(new SelectItem(rap.getCodPais(), rap.getNomPais()));
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public static List<Pais> listPais() {
        List<Pais> listAccion;
        Connection conexion = DBConnection.getConexion();
        listAccion = PaisDAO.listarPais(conexion);
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error [PaisFCD][listPais][SQLException]: " + e.getMessage());
        }
        return listAccion;
    }

//    public static List<Pais> listPaisPorNombre(Pais pais) {
//        List<Pais> listAccion;
//        Connection conexion = Conexion.getConexion();
//      listAccion = PaisDAO.listResultadoBusquedaPorNombre(conexion,pais);
//        try {
//            conexion.close();
//        } catch (SQLException e) {
//            System.out.println("Error [PaisFCD][listPaisPorNombre][SQLException]: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return listAccion;
//    }
    public static boolean insertaPais(Pais pais) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = PaisDAO.insertPais(conn, pais);
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error [PaisFCD][listPais][SQLException]: " + e.getMessage());
        }
        return b;

    }
      public static boolean updatePais(Pais pais, Pais paisOri) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = PaisDAO.updatePais(conn, pais, paisOri);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }
         public static boolean deletePais(Pais pais) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = PaisDAO.deletePais(conn, pais);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

}
