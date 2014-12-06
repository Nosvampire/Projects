package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Condicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CondicionDAO {

    Connection conn = DBConnection.getConexion();

    public void insertCondicion(Condicion con) {
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO condicion VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConCodigo());
            stmt.setString(2, con.getConDescripcion());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CondicionDAO.insertCondicion", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateCondicion(Condicion con) {
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE condicion SET con_descripcion = ? WHERE con_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConDescripcion());
            stmt.setString(2, con.getConCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CondicionDAO.updateCondicion", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteCondicion(Condicion con) {
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM condicion where con_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CondicionDAO.deleteCondicion", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Condicion> listarCondicion() {
        List<Condicion> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM condicion";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Condicion con = new Condicion();
                con.setConCodigo(rs.getString("con_codigo"));
                con.setConDescripcion(rs.getString("con_descripcion"));

                lista.add(con);
            }
        } catch (Exception ex) {
            throw new RuntimeException("CondicionDAO.listarCondicion", ex);
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
