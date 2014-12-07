/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 */
public class UsuarioFCD {

    public static boolean checkEstadoUsuario(int rut, String dv) {
        Connection conn = DBConnection.getConexion();
        boolean b = false;
        UsuarioDAO.checkEstadoUsuario(conn, rut, dv);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public static String checkTipoUsuario(int usuario, String password) {
        Connection conn = DBConnection.getConexion();
        String tipoUsuario = "";
        tipoUsuario = UsuarioDAO.loginUsuario(conn, usuario, password);
        return tipoUsuario;
    }
}
