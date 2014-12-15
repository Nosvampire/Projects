/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.UsuarioDAO;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
        b = UsuarioDAO.checkEstadoUsuario(conn, rut, dv);
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
    public static List<Usuario> buscarUsuarioNombre(String nombres, String priApellido, String secApellido){
        Connection conn = DBConnection.getConexion();
        List<Usuario> listUsuario = UsuarioDAO.buscarUsuarioNombre(conn, nombres, priApellido, secApellido);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return listUsuario;
    }
    
    public static List<Usuario> buscarUsuarioRut(int rut){
        Connection conn = DBConnection.getConexion();
        List<Usuario> listUsuario = UsuarioDAO.buscarUsuaruioRut(conn, rut);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return listUsuario;
    }
    
    public static void insertUsuario(Usuario usuario){
        Connection conn = DBConnection.getConexion();
        UsuarioDAO.insertUsuario(conn, usuario);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public static void updateUsuario(Usuario usuario){
        Connection conn = DBConnection.getConexion();
        UsuarioDAO.updateUsuario(conn, usuario);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public static void deleteUsuario(Usuario usuario){
        Connection conn = DBConnection.getConexion();
        UsuarioDAO.deleteUsuario(conn, usuario);
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
}
