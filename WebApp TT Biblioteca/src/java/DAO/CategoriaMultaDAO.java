package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.CategoriaMulta;
import POJO.Copia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaMultaDAO {

    Connection conn = DBConnection.getConexion();

    public void insertCategoriaMulta(CategoriaMulta cm) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO categoria_multa VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamCod());
            stmt.setString(2, cm.getCamNombre());
            stmt.setString(3, cm.getCamDescripcion());
            stmt.setInt(4, cm.getCamValorMultaDia());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CategoriaMultaDAO.insertCategoriaMulta", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateCategoriaMulta(CategoriaMulta cm) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE categoria_multa SET "
                    + "cam_nombre = ?, "
                    + "cam_descripcion = ?, "
                    + "cam_valorMultaDia = ? "
                    + "WHERE cam_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamNombre());
            stmt.setString(2, cm.getCamDescripcion());
            stmt.setInt(3, cm.getCamValorMultaDia());
            stmt.setString(4, cm.getCamCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CategoriaMultaDAO.updateCategoriaMulta", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteCategoriaMulta(CategoriaMulta cm, CategoriaMulta cm2, Copia cp) {
        PreparedStatement stmt = null;
        PreparedStatement pstmt = null;
        try {
            String sqluc = "UPDATE copia SET cop_categoriaMulta = ? WHERE cop_categoriaMulta = ?";
            pstmt = conn.prepareStatement(sqluc);
            pstmt.setString(1, cm2.getCamCod());
            pstmt.setString(2, cm.getCamCod());

            pstmt.executeUpdate();

            String sql = "DELETE FROM categoria_multa WHERE cam_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cm.getCamCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CategoriaMultaDAO.deleteCategoriaMulta", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<CategoriaMulta> listarCategoriaMulta() {
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
