package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.Dewey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeweyDAO {

    Connection conn = DBConnection.getConexion();

    public static boolean insertDewey(Connection conn, Dewey dw) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO dewey VALUES(?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dw.getDwCod());
            stmt.setInt(2, dw.getDwCodSuperior());
            stmt.setString(3, dw.getDwCategoria());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][insertCurso][SQLException]: " + ex.getMessage());
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

    public static boolean updateDewey(Connection conn, Dewey dw, Dewey deweyOri) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE dewey SET dw_categoria = ?, dw_cod = ? WHERE dw_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dw.getDwCategoria());
            stmt.setInt(2, dw.getDwCod());

            stmt.setInt(3, deweyOri.getDwCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][insertCurso][SQLException]: " + ex.getMessage());
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

//    No se si se podria eliminar el codigo ... 
//    en mi opinion no .. 
//    pero por si acaso lo dejo igual..
    public static boolean deleteDewey(Connection conn, Dewey dw) {
        boolean b = false;
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM dewey WHERE dw_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dw.getDwCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error [CursoDAO][insertCurso][SQLException]: " + ex.getMessage());
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

    public static List<Dewey> listarDewey(Connection conn) {
        List<Dewey> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM dewey ORDER BY dw_cod";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Dewey dw = new Dewey();
                dw.setDwCod(rs.getInt("dw_cod"));
                dw.setDwCodSuperior(rs.getInt("dw_cod_superior"));
                dw.setDwCategoria(rs.getString("dw_categoria"));

                lista.add(dw);
            }
        } catch (Exception ex) {
            throw new RuntimeException("DeweyDAO.listarDewey", ex);
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
