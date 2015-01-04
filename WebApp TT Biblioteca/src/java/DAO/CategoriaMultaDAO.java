package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.CategoriaMulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaMultaDAO {

    Connection conn = DBConnection.getConexion();

    public static boolean insertCategoriaMulta(Connection conn, CategoriaMulta cm) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO categoria_multa VALUES(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamCod());
            stmt.setString(2, cm.getCamNombre());
            stmt.setString(3, cm.getCamDescripcion());
            stmt.setInt(4, cm.getCamCantDiasPrestamo());
            stmt.setInt(5, cm.getCamValorMultaDia());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CategoriaDAO][insertCategoriaMulta][SQLException]: " + ex.getMessage());
            b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static boolean updateCategoriaMulta(Connection conn, CategoriaMulta cm, CategoriaMulta cmOriginal) {
        PreparedStatement stmt = null;
        boolean b = false;
        try {
            String sql = "UPDATE categoria_multa SET "
                    + "cam_cod = ?, "
                    + "cam_nombre = ?, "
                    + "cam_descripcion = ?, "
                    + "cam_cantDiasPrestamo = ?, "
                    + "cam_valorMultaDia = ? "
                    + "WHERE cam_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamCod());
            stmt.setString(2, cm.getCamNombre());
            stmt.setString(3, cm.getCamDescripcion());
            stmt.setInt(4, cm.getCamCantDiasPrestamo());
            stmt.setInt(5, cm.getCamValorMultaDia());
            stmt.setString(6, cmOriginal.getCamCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CategoriaMultaDAO][updateCategoriaMulta][SQLException]: " + ex.getMessage());
            b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static boolean deleteCategoriaMulta(Connection conn, CategoriaMulta cm) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM categoria_multa WHERE cam_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CategoriaDAO][deleteCategoriaMulta][SQLException]: " + ex.getMessage());
            b = true;
        } finally {
            try {
                stmt.close();

            } catch (Exception e) {
            }
        }
        return b;
    }

    public static List<CategoriaMulta> listarCategoriaMulta(Connection conn) {
        List<CategoriaMulta> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM categoria_multa";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoriaMulta cm = new CategoriaMulta();
                cm.setCamCod(rs.getString("cam_cod"));
                cm.setCamNombre(rs.getString("cam_nombre"));
                cm.setCamDescripcion(rs.getString("cam_descripcion"));
                cm.setCamCantDiasPrestamo(rs.getInt("cam_cantDiasPrestamo"));
                cm.setCamValorMultaDia(rs.getInt("cam_valorMultaDia"));

                lista.add(cm);
            }
        } catch (Exception ex) {
            throw new RuntimeException("CategoriaMultaDAO.listarCategoriaMulta", ex);
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
