package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Condicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CondicionDAO {

    Connection conn = DBConnection.getConexion();

    public static boolean insertCondicion(Connection conn, Condicion con) {
        PreparedStatement stmt = null;
        boolean b = false;

        try {
            String sql = "INSERT INTO condicion VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConCodigo());
            stmt.setString(2, con.getConDescripcion());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error [CondicionDAO][insertCondicion][SQLException]: " + ex.getMessage());
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

    public static boolean updateCondicion(Connection conn, Condicion con, Condicion conOriginal) {
        PreparedStatement stmt = null;
        boolean b = false;
        try {
            String sql = "UPDATE condicion SET con_descripcion = ?, con_codigo = ? WHERE con_codigo = ? AND con_descripcion = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConDescripcion());
            stmt.setString(2, con.getConCodigo());
            stmt.setString(3, conOriginal.getConCodigo());
            stmt.setString(4, conOriginal.getConDescripcion());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CondicionDAO][updateCondicion][SQLException]: " + ex.getMessage());
            b = true;
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static boolean deleteCondicion(Connection conn, Condicion con) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {
                String sql = "DELETE FROM condicion WHERE con_codigo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, con.getConCodigo());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CondicionDAO][deleteCondicion][SQLException]: " + ex.getMessage());
            b = true;
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static List<Condicion> listarCondicion(Connection conn) {
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
