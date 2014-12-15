/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.CopiaDAO;
import POJO.Autor;
import POJO.Copia;
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
public class CopiaFCD {

    public static List<Copia> listResultadoBusqueda(int copTitulo) {
        Connection conn = DBConnection.getConexion();
        List<Copia> listCopia = new ArrayList<>();
        listCopia = CopiaDAO.listarCopias(conn, copTitulo);
        for (int i = 0; i < listCopia.size(); i++) {
            List<Autor> listAutor = AutorFCD.listAutoresPorCodCopia(listCopia.get(i).getCopCod());
            if (listAutor != null) {
                listCopia.get(i).setListAutores(listAutor);
            }
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCopia;
    }

    public static void modificarCopia(Copia copia) {
        Connection conn = DBConnection.getConexion();
        CopiaDAO.updateCopia(conn, copia);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AutorFCD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
