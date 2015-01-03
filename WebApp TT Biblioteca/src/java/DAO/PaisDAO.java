package DAO;

// CRUD listo
import POJO.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {

    public static boolean insertPais(Connection conn, Pais pais) {
        PreparedStatement stmt = null;
        boolean b = false;
        try {
            String sql = "INSERT INTO pais VALUES (?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pais.getCodPais());
            stmt.setString(2, pais.getNomPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("PaisDAO.insertPais", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error [PaisDAO][insertPais][SQLException]: " + e.getMessage());
                b = true;
            }
        }
        return b;
    }

    public static boolean updatePais(Connection conn, Pais pais,Pais paisOri) {
        boolean b = true;
        PreparedStatement stmt = null;

        try {
            String sql = "UPDATE pais SET"
                    + " nom_pais = ?,"
                    + " cod_pais = ?"
                    + " WHERE cod_pais = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pais.getNomPais());
            stmt.setString(2, pais.getCodPais());
             stmt.setString(3, paisOri.getCodPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
         b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error [PaisDAO][updatePais][SQLException]: " + e.getMessage());
            }
        }
        return  b;
    }

    public static boolean deletePais(Connection conn, Pais pais) {
        boolean b = false;
        PreparedStatement stmt = null;

        try {
            String sql = "DELETE FROM pais WHERE cod_pais = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pais.getCodPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
          b = true;
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error [PaisDAO][deletePais][SQLException]: " + e.getMessage());
            }
        }
        return b;
    }

    public static List<Pais> listarPais(Connection conn) {
        List<Pais> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM pais";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pais ps = new Pais();
                ps.setCodPais(rs.getString("cod_pais"));
                ps.setNomPais(rs.getString("nom_pais"));

                lista.add(ps);
            }
        } catch (Exception ex) {
            throw new RuntimeException("PaisDAO.listarPais", ex);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                stmt.close();
            } catch (Exception e) {
                System.out.println("Error [PaisDAO][listarPais][SQLException]: " + e.getMessage());
            }
        }
        return lista;
    }
}
