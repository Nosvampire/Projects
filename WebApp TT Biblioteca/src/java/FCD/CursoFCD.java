/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FCD;

import Connection.DBConnection;
import DAO.CursoDAO;
import POJO.Curso;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author nicolas.molina
 */
public class CursoFCD {
    public static List<Curso> listResultadoBusqueda(){
        Connection conn = DBConnection.getConexion();
        List<Curso> listResultadoCurso = CursoDAO.listarCurso(conn);
        return listResultadoCurso;
    }
}
