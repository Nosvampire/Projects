package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public static boolean insertCurso(Connection conn, Curso cur) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO curso VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurCodigo());
            stmt.setString(2, cur.getCurDescripcion());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][insertCurso][SQLException]: " + ex.getMessage());
            ex.printStackTrace();
            b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static boolean updateCurso(Connection conn, Curso cur, Curso curOriginal) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE curso SET cur_descripcion = ?, cur_codigo = ? WHERE cur_codigo = ? AND cur_descripcion = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurDescripcion());
            stmt.setString(2, cur.getCurCodigo());
            stmt.setString(3, curOriginal.getCurCodigo());
            stmt.setString(4, curOriginal.getCurDescripcion());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][updatetCurso][SQLException]: " + ex.getMessage());
            ex.printStackTrace();
            b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static boolean deleteCurso(Connection conn, Curso cur) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM curso WHERE cur_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][deleteCurso][SQLException]: " + ex.getMessage());
            ex.printStackTrace();
            b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static List<Curso> listarCurso(Connection conn) {
        List<Curso> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM curso";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Curso cur = new Curso();
                cur.setCurCodigo(rs.getString("cur_codigo"));
                cur.setCurDescripcion(rs.getString("cur_descripcion"));

                lista.add(cur);
            }
        } catch (Exception ex) {
            throw new RuntimeException("CursoDAO.listarCurso", ex);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }
}
