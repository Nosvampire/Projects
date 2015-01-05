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

    public static boolean insertEditorial(Connection conn, Editorial ed) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO editorial VALUES(?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ed.getEdiCod());
            stmt.setString(2, ed.getEdiNombre());
            stmt.setString(3, ed.getEdiPais().getCodPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [editorialDAO][insertEditorial][SQLException]: " + ex.getMessage());
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

    public static boolean updateEditorial(Connection conn, Editorial ed, Editorial ediOriginal) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE editorial SET"
                    + " edi_cod = ?, "
                    + "edi_nombre = ?, "
                    + "edi_pais = ? "
                    + "WHERE edi_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ed.getEdiCod());
            stmt.setString(2, ed.getEdiNombre());
            stmt.setString(3, ed.getEdiPais().getCodPais());
            stmt.setInt(4, ediOriginal.getEdiCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [editorialDAO][updateEditorial][SQLException]: " + ex.getMessage());
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

    public static boolean deleteEditorial(Connection conn, Editorial ed) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM editorial WHERE edi_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ed.getEdiCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [editorialDAO][deleteEditorial][SQLException]: " + ex.getMessage());
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
            System.out.println("Error [editorialDAO][listarEditorial][SQLException]: " + ex.getMessage());
            ex.printStackTrace();
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
