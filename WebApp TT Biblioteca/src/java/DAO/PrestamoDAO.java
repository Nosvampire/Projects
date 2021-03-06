package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Copia;
import POJO.Prestamo;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    Connection conn = DBConnection.getConexion();

    public static void insertPrestamo(Connection conn, Prestamo pre) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO prestamo VALUES (?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pre.getUsuario().getUsrRut());
            stmt.setString(2, pre.getUsuario().getUsrDv());
            stmt.setInt(3, pre.getCopia().getCopTitulo());
            stmt.setInt(4, pre.getCopia().getCopCod());
            stmt.setDate(5, pre.getPreFecha());
            stmt.setDate(6, pre.getPreFechaDevolucion());
            stmt.setInt(7, pre.getPreValorCancelado());
            stmt.setInt(8, pre.getPreMulta());
            stmt.setDate(9, pre.getPreFechaDevEfectiva());
            stmt.setString(10, pre.getPreVigencia());

            stmt.executeUpdate();
        } catch (SQLException ex) {

            System.out.println("Error [PrestamoDAO][insertPrestamo][SQLException]: " + ex.getMessage());
            throw new RuntimeException("PrestamoDAO.Prestamo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updatePrestamo(Prestamo pre) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE prestamo SET "
                    + "pre_fechaDevolucion = ?, "
                    + "pre_valorCancelado = ?, "
                    + "pre_multa = ?, "
                    + "pre_fechaDevEfectiva = ?, "
                    + "pre_vigencia = ? "
                    + "WHERE pre_rut = ? AND "
                    + "pre_dv = ? AND "
                    + "pre_titulo = ? AND "
                    + "pre_copia = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, pre.getPreFechaDevolucion());
            stmt.setInt(2, pre.getPreValorCancelado());
            stmt.setInt(3, pre.getPreMulta());
            stmt.setDate(4, pre.getPreFechaDevEfectiva());
            stmt.setString(5, pre.getPreVigencia());
            stmt.setInt(6, pre.getUsuario().getUsrRut());
            stmt.setString(7, pre.getUsuario().getUsrDv());
            stmt.setInt(8, pre.getCopia().getCopTitulo());
            stmt.setInt(9, pre.getCopia().getCopCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("PrestamoDAO.Prestamo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deletePrestamo(Prestamo pre) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM prestamo "
                    + "WHERE pre_rut = ? AND "
                    + "pre_dv = ? AND "
                    + "pre_titulo = ? AND "
                    + "pre_copia = ? AND "
                    + "pre_fecha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pre.getUsuario().getUsrRut());
            stmt.setString(2, pre.getUsuario().getUsrDv());
            stmt.setInt(3, pre.getCopia().getCopTitulo());
            stmt.setInt(4, pre.getCopia().getCopCod());
            stmt.setDate(5, pre.getPreFecha());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("PrestamoDAO.Prestamo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Prestamo> listarPrestamo() {
        List<Prestamo> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM prestamo p,usuario u, copia c "
                    + "WHERE p.pre_rut = u.usr_rut AND "
                    + "p.pre_dv = u.usr_dv AND "
                    + "p.pre_titulo = c.cop_titulo AND "
                    + "p.pre_copia = c.cop_cod";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Prestamo pre = new Prestamo();
                Usuario usr = new Usuario();
                Copia cop = new Copia();

                // Recoleccion datos Usuario
                usr.setUsrRut(rs.getInt("usr_rut"));
                usr.setUsrDv(rs.getString("usr_dv"));
                // Falta completar de ser necesario

                // Recoleccion datos Copia
                cop.setCopTitulo(rs.getInt("cop_titulo"));
                cop.setCopCod(rs.getInt("cop_cod"));
                // Falta completar de ser necesario

                // Asignacion datos a prestamo
                pre.setUsuario(usr);
                pre.setCopia(cop);
                pre.setPreFecha(rs.getDate("pre_fecha"));
                pre.setPreFechaDevolucion(rs.getDate("pre_fechaDevolucion"));
                pre.setPreValorCancelado(rs.getInt("pre_valorCancelado"));
                pre.setPreMulta(rs.getInt("pre_multa"));
                pre.setPreFechaDevEfectiva(rs.getDate("pre_fechaDevEfectiva"));
                pre.setPreVigencia(rs.getString("pre_vigencia"));

                lista.add(pre);
            }
        } catch (Exception ex) {
            throw new RuntimeException("PrestamoDAO.listarPrestamo", ex);
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
