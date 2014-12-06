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
import javax.faces.model.SelectItem;

/**
 *
 * @author Niko
 */
public class PaisFCD {

    public static List<SelectItem> listResultadoBusqueda() {
        ArrayList<SelectItem> r = new ArrayList<SelectItem>();
        for (Pais rap : PaisFCD.listPais()) {
            r.add(new SelectItem(rap.getCodPais(), rap.getNomPais()));
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
            e.printStackTrace();
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

    public static int insertaPais(Pais pais) {
        int error;
        Connection con = DBConnection.getConexion();
        error = PaisDAO.insertPais(con, pais);
        return error;
    }

}
