package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Copia;
import POJO.Prestamo;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    Connection conn = DBConnection.getConexion();

    public static boolean insertPrestamo(Connection conn, Prestamo pre) {
        boolean error = false;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO prestamo VALUES (?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pre.getUsuario().getUsrRut());
            stmt.setString(2, pre.getUsuario().getUsrDv());
            stmt.setInt(3, pre.getCopia().getCopTitulo());
            stmt.setInt(4, pre.getCopia().getCopCod());
            stmt.setDate(5, (Date) pre.getPreFecha());
            stmt.setDate(6, (Date) pre.getPreFechaDevolucion());
            stmt.setInt(7, pre.getPreValorCancelado());
            stmt.setInt(8, pre.getPreMulta());
            stmt.setDate(9, (Date) pre.getPreFechaDevEfectiva());
            stmt.setString(10, pre.getPreVigencia());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            error = true;
            System.out.println("Error [PrestamoDAO][insertPrestamo][SQLException]: " + ex.getMessage());

        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        return error;
    }

    public static boolean updatePrestamo(Connection conn, Prestamo pre, Prestamo prestamoOri) {
        boolean b = false;
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
            stmt.setDate(1, new java.sql.Date(pre.getPreFechaDevolucion().getTime()));
            stmt.setInt(2, pre.getPreValorCancelado());
            stmt.setInt(3, pre.getPreMulta());
            stmt.setDate(4, new java.sql.Date(pre.getPreFechaDevEfectiva().getTime()));
            stmt.setString(5, pre.getPreVigencia());
            stmt.setInt(6, pre.getUsuario().getUsrRut());
            stmt.setString(7, pre.getUsuario().getUsrDv());
            stmt.setInt(8, pre.getCopia().getCopTitulo());
            stmt.setInt(9, pre.getCopia().getCopCod());

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
            stmt.setDate(5, (Date) pre.getPreFecha());

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

    public static List<Prestamo> listarPrestamo(Connection conn, java.sql.Date fechaInicio, java.sql.Date fechaTermino, int rut) {
        List<Prestamo> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM prestamo p,usuario u, copia c, titulo t"
                    + " WHERE p.pre_rut = u.usr_rut AND "
                    + "p.pre_dv = u.usr_dv AND "
                    + "p.pre_titulo = c.cop_titulo AND "
                    + "p.pre_copia = c.cop_cod AND"
                    + " t.tit_cod = c.cop_titulo"
                    + " AND pre_fecha BETWEEN ? AND ?"
                    + " AND pre_rut = ?";
            System.out.println("sql : " + sql);
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, fechaInicio);
            stmt.setDate(2, fechaTermino);
            stmt.setInt(3, rut);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Prestamo pre = new Prestamo();
                Usuario usr = new Usuario();
                Copia cop = new Copia();

                // Recoleccion datos Usuario
                usr.setUsrRut(rs.getInt("usr_rut"));
                usr.setUsrDv(rs.getString("usr_dv"));
                // Falta completar de ser necesario

                // Recoleccion datos Copia
                cop.setCopNombre(rs.getString("tit_nombre"));
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
