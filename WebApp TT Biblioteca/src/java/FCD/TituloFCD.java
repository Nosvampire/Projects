/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.TituloDAO;
import POJO.Titulo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Niko
 */
public class TituloFCD {

    public static List<Titulo> listResultadoBusqueda(String titNombre) {
        Connection conn = DBConnection.getConexion();
        List<Titulo> listResultadoBusqueda = new ArrayList<>();
        listResultadoBusqueda = TituloDAO.listarTitulo(conn, titNombre);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listResultadoBusqueda;
    }
}
