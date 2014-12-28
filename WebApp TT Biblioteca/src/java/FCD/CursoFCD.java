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

    public static List<Curso> listResultadoBusqueda() {
        Connection conn = DBConnection.getConexion();
        List<Curso> listResultadoCurso = CursoDAO.listarCurso(conn);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return listResultadoCurso;
    }

    public static boolean insertCurso(Curso curso) {
        boolean b = false;
        Connection conn = DBConnection.getConexion();
        b = CursoDAO.insertCurso(conn, curso);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean updateCurso(Curso curso, Curso curOriginal) {
        boolean b = false;
        Connection conn = DBConnection.getConexion();
        b = CursoDAO.updateCurso(conn, curso, curOriginal);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

    public static boolean deleteCurso(Curso condicion) {
        boolean b;
        Connection conn = DBConnection.getConexion();
        b = CursoDAO.deleteCurso(conn, condicion);
        try {
            conn.close();
        } catch (Exception e) {
        }
        return b;
    }

}
