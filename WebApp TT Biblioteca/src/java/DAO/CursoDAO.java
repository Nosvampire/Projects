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

    Connection conn = DBConnection.getConexion();

    public void insertCurso(Curso cur) {
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO curso VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurCodigo());
            stmt.setString(2, cur.getCurDescripcion());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CursoDAO.insertCurso", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateCurso(Curso cur) {
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE curso SET cur_descripcion = ? WHERE cur_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurDescripcion());
            stmt.setString(2, cur.getCurCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CursoDAO.updateCurso", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteCurso(Curso cur) {
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM curso WHERE cod_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cur.getCurCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CursoDAO.deleteCurso", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Curso> listarCurso() {
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
