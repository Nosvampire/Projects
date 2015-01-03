package DAO;

// CRUD listo.
import POJO.Autor;
import POJO.Pais;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutorDAO {

    public static boolean insertAutor(Connection conn, Autor au) {
        boolean b= false;
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
            System.out.println("Error [AccionesEventosDAO][listResultadoBusqueda][SQLException]: " + ex.getMessage());
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

    public static boolean updateAutor(Connection conn, Autor au,Autor autorOri) {
        boolean b = false;
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
            System.out.println("Error [AccionesEventosDAO][listResultadoBusqueda][SQLException]: " + ex.getMessage());
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

    public static boolean deleteAutor(Connection conn, Autor au) {
        boolean b = false;
        PreparedStatement stmt = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM autor WHERE aut_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, au.getAutCod());

            stmt.executeUpdate();

         

           
        } catch (Exception ex) {
            System.out.println("Error [AccionesEventosDAO][listResultadoBusqueda][SQLException]: " + ex.getMessage());
            ex.printStackTrace();
           b = true;
        } finally {
            try {
                stmt.close();
                pstmt.close();
            } catch (Exception e) {
            }
        }
        return b;
    }

    public static List<Autor> listarAutor(Connection conn, String nombre, String apellido) {
        List<Autor> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM autor a , pais p "
                    + "WHERE a.aut_pais = p.cod_pais"
                    + " AND aut_nombre LIKE ?"
                    + " AND aut_apellido LIKE ?";
            CallableStatement cs = conn.prepareCall(sql);

            cs.setString(1, "%" + nombre + "%");
            cs.setString(2, "%" + apellido + "%");
            System.out.println("sql listAutor: " + sql);
            ResultSet res = cs.executeQuery();
            while (res.next()) {
                Autor aut = new Autor();
                Pais ps = new Pais();
                aut.setAutCod(res.getInt("aut_cod"));
                aut.setAutNombre(res.getString("aut_nombre"));
                aut.setAutApellido(res.getString("aut_apellido"));
                aut.setAutSeudonimo(res.getString("aut_seudonimo"));
                ps.setCodPais(res.getString("cod_pais"));
                ps.setNomPais(res.getString("nom_pais"));
                aut.setAutPais(ps);

                lista.add(aut);
            }
            res.close();
            cs.close();
            
        } catch (SQLException | RuntimeException ex) {
            throw new RuntimeException("AutorDAO.listarAutor", ex);
        } finally {
            try {

            } catch (Exception e) {
            }
            try {

            } catch (Exception e) {
            }
        }
        return lista;
    }

    public static List<Autor> listAutoresPorCodCopia(Connection conn, int codCopia) {

        List<Autor> listAutor = new ArrayList<>();
        try {
            String sql = "SELECT a.aut_nombre, a.aut_apellido, a.aut_seudonimo, a.aut_cod"
                    + " FROM autor a "
                    + " INNER JOIN copia_autor cp ON cp.cod_autor = a.aut_cod"
                    + " INNER JOIN copia c ON c.cop_cod = cp.cod_copia"
                    + " WHERE cp.cod_copia = ?"
                    + " group by a.aut_nombre, a.aut_apellido, a.aut_seudonimo, a.aut_cod";
            System.out.println("sql AutorDAO.listAutoresPorCodCopia: " + sql);
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, codCopia);
            ResultSet res = cstmt.executeQuery();
            while (res.next()) {
                Autor a = new Autor(
                        res.getInt("aut_cod"),
                        res.getString("aut_nombre"),
                        res.getString("aut_apellido"),
                        res.getString("aut_seudonimo"),
                        null
                );
                listAutor.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAutor;

    }
}
