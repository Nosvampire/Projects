package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Editorial;
import POJO.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EditorialDAO {

    Connection conn = DBConnection.getConexion();

    public static void insertEditorial(Connection conn, Editorial ed) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO editorial VALUES(?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ed.getEdiCod());
            stmt.setString(2, ed.getEdiNombre());
            stmt.setString(3, ed.getEdiPais().getCodPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("EditorialDAO.insertEditorial", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static void updateEditorial(Connection conn, Editorial ed) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE editorial SET "
                    + "edi_nombre = ?, "
                    + "edi_pais = ? "
                    + "WHERE edi_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ed.getEdiNombre());
            stmt.setString(2, ed.getEdiPais().getCodPais());
            stmt.setInt(3, ed.getEdiCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("EditorialDAO.updateEditorial", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static void deleteEditorial(Connection conn, Editorial ed) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM editorial WHERE edi_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ed.getEdiCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("EditorialDAO.deleteEditorial", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static List<Editorial> listarEditorial(Connection conn) {
        List<Editorial> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM editorial e, pais p WHERE e.edi_pais = p.cod_pais";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Editorial ed = new Editorial();
                Pais ps = new Pais();
                ed.setEdiCod(rs.getInt("edi_cod"));
                ed.setEdiNombre(rs.getString("edi_nombre"));
                ps.setCodPais(rs.getString("cod_pais"));
                ps.setNomPais(rs.getString("nom_pais"));
                ed.setEdiPais(ps);

                lista.add(ed);
            }
        } catch (Exception ex) {
            throw new RuntimeException("DAO.listar", ex);
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
