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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niko
 */
public class CopiaFCD {
    
    public static List<Copia> listResultadoBusqueda(int copTitulo) {
        Connection conexion = DBConnection.getConexion();
        List<Copia> listCopia = new ArrayList<>();
        listCopia = CopiaDAO.listarCopias(conexion, copTitulo);
        for (int i = 0; i < listCopia.size(); i++) {
            List<Autor> listAutor = AutorFCD.listAutoresPorCodCopia(listCopia.get(i).getCopCod());
            if (listAutor != null) {
                listCopia.get(i).setListAutores(listAutor);
            }
        }
        
        return listCopia;
    }
}
