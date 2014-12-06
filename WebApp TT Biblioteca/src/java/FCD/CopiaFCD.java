/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.CopiaDAO;
import POJO.Copia;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niko
 */
public class CopiaFCD {

    public static List<Copia> listResultadoBusqueda(int copCod, String copTitulo) {
        Connection conexion = DBConnection.getConexion();
        List<Copia> listCopia = new ArrayList<>();
        listCopia = CopiaDAO.listarCopias(conexion, copCod, copTitulo);
        return listCopia;
    }
}
