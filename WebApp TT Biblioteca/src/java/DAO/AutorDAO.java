package DAO;

// CRUD listo.
import POJO.Autor;
import POJO.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    public static void insertAutor(Connection conn, Autor au) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO autor VALUES(?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, au.getAutCod());
            stmt.setString(2, au.getAutNombre());
            stmt.setString(3, au.getAutApellido());
            stmt.setString(4, au.getAutSeudonimo());
            stmt.setString(5, au.getAutPais().getCodPais());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("AutorDAO.insertAutor", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static void updateAutor(Connection conn, Autor au) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE autor SET "
                    + "aut_nombre = ?, "
                    + "aut_apellido = ?, "
                    + "aut_seudonimo = ?, "
                    + "aut_pais = ? "
                    + "WHERE aut_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, au.getAutNombre());
            stmt.setString(2, au.getAutApellido());
            stmt.setString(3, au.getAutSeudonimo());
            stmt.setString(4, au.getAutPais().getCodPais());
            stmt.setInt(5, au.getAutCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("AutorDAO.updateAutor", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static void deleteAutor(Connection conn, Autor au) {
        PreparedStatement stmt = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM autor WHERE aut_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, au.getAutCod());

            stmt.executeUpdate();

            String sqldca = "DELETE FROM copia_autor WHERE aut_cod = ?";
            pstmt = conn.prepareStatement(sqldca);
            pstmt.setInt(1, au.getAutCod());

            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("AutorDAO.deleteAutor", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static List<Autor> listarAutor(Connection conn,String nombre,String apellido) {
        List<Autor> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM autor a , pais p "
                    + "WHERE a.aut_pais = p.cod_pais"
                    + " AND aut_nombre LIKE ?"
                    + " AND aut_apellido LIKE ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nombre + "%");
            stmt.setString(2, "%" + apellido + "%");
            System.out.println("sql listAutor: " + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Autor aut = new Autor();
                Pais ps = new Pais();
                aut.setAutCod(rs.getInt("aut_cod"));
                aut.setAutNombre(rs.getString("aut_nombre"));
                aut.setAutApellido(rs.getString("aut_apellido"));
                aut.setAutSeudonimo(rs.getString("aut_seudonimo"));
                ps.setCodPais(rs.getString("cod_pais"));
                ps.setNomPais(rs.getString("nom_pais"));
                aut.setAutPais(ps);

                lista.add(aut);
            }
        } catch (SQLException | RuntimeException ex) {
            throw new RuntimeException("AutorDAO.listarAutor", ex);
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
