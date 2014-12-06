package DAO;

import Connection.DBConnection;
import POJO.Dewey;
import POJO.Titulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TituloDAO {

    Connection conn = DBConnection.getConexion();

    public void insertTitulo(Titulo tt) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO titulo VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tt.getTitCod());
            stmt.setString(2, tt.getTitNombre());
            stmt.setString(3, tt.getTitTipo());
            stmt.setInt(4, tt.getTitDewey().getDwCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("TituloDAO.insertTitulo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateTitulo(Titulo tt) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE titulo SET "
                    + "tit_nombre = ?, "
                    + "tit_tipo = ?, "
                    + "tit_dewey = ? "
                    + "WHERE tit_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tt.getTitNombre());
            stmt.setString(2, tt.getTitTipo());
            stmt.setInt(3, tt.getTitDewey().getDwCod());
            stmt.setInt(4, tt.getTitCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("TituloDAO.updateTitulo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteTitulo(Titulo tt) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM titulo WHERE tit_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, tt.getTitCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("TituloDAO.deleteTitulo", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static List<Titulo> listarTitulo(Connection conn, String titNombre) {
        List<Titulo> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT "
                    + " t.tit_cod,"
                    + " t.tit_nombre,"
                    + " t.tit_tipo,"
                    + " t.tit_dewey,"
                    + " d.dw_cod,"
                    + " d.dw_cod_superior,"
                    + " d.dw_categoria"
                    + ""
                    + " FROM "
                    + " titulo t"
                    + " INNER JOIN dewey d ON d.dw_cod = t.tit_dewey"
                    + " WHERE "
                    + " UPPER(tit_nombre) LIKE ? ";
            System.out.println("sql [tituloDAO] [listarTitulo]: "+sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, titNombre);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Dewey d = new Dewey(
                        rs.getInt("dw_cod"),
                        rs.getInt("dw_cod_superior"),
                        rs.getString("dw_categoria")
                );
                Titulo t = new Titulo(
                        rs.getInt("tit_cod"),
                        rs.getString("tit_nombre"),
                        rs.getString("tit_tipo"),
                        d
                );
                lista.add(t);
            }
        } catch (Exception ex) {
            throw new RuntimeException("DAO.listarTitulo", ex);
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
