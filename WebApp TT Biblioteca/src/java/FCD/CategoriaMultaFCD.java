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

/**
 *
 * @author Niko
 */
public class CategoriaMultaFCD {

    public static void insertCategoriaMulta(CategoriaMulta categoriaMulta) {
        Connection conn = DBConnection.getConexion();
        CategoriaMultaDAO.insertCategoriaMulta(conn, categoriaMulta);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void updateCategoriaMulta(CategoriaMulta categoriaMulta) {
        Connection conn = DBConnection.getConexion();
        CategoriaMultaDAO.updateCategoriaMulta(conn, categoriaMulta);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void deleteCategoriaMulta(CategoriaMulta categoriaMulta) {
        Connection conn = DBConnection.getConexion();
        CategoriaMultaDAO.updateCategoriaMulta(conn, categoriaMulta);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}
