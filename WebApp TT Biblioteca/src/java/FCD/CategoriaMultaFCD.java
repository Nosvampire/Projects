/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.CategoriaMultaDAO;
import POJO.CategoriaMulta;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niko
 */
public class CategoriaMultaFCD {

    public static boolean insertCategoriaMulta(CategoriaMulta categoriaMulta) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = CategoriaMultaDAO.insertCategoriaMulta(conn, categoriaMulta);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean deleteCategoriaMulta(CategoriaMulta categoriaMulta) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = CategoriaMultaDAO.deleteCategoriaMulta(conn, categoriaMulta);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static List<CategoriaMulta> selectCategoriaMulta() {
        Connection conn = DBConnection.getConexion();
        List<CategoriaMulta> listCategoriaMulta = new ArrayList<>();
        listCategoriaMulta = CategoriaMultaDAO.listarCategoriaMulta(conn);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return listCategoriaMulta;
    }

    public static boolean updateCategoriaMulta(CategoriaMulta categoriaMulta, CategoriaMulta categoriaMultaOri) {
        Connection conn = DBConnection.getConexion();
        boolean b;
        b = CategoriaMultaDAO.updateCategoriaMulta(conn, categoriaMulta, categoriaMultaOri);

        return b;
    }
}
