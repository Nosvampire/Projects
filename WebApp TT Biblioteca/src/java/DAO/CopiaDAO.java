package DAO;

// CRUD listo
import Connection.DBConnection;
import POJO.CategoriaMulta;
import POJO.Condicion;
import POJO.Copia;
import POJO.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CopiaDAO {

    Connection conn = DBConnection.getConexion();

    public static void insertCopia(Connection conn,Copia cop) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO copia VALUES (?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cop.getCopTitulo());
            stmt.setInt(2, cop.getCopCod());
            stmt.setInt(3, cop.getEditorial().getEdiCod());
            stmt.setInt(4, cop.getCopEdicion());
            stmt.setInt(5, cop.getCopPaginas());
            stmt.setString(6, cop.getCopTipo());
            stmt.setString(7, cop.getCategoriaMulta().getCamCod());
            stmt.setString(8, cop.getCondicion().getConCodigo());
            stmt.setString(9, cop.getCopYearPublicacion());
            stmt.setString(10, cop.getCopISBN());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CopiaDAO.insertCopia", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static void updateCopia(Connection conn,Copia cop) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE copia SET "
                    + "cop_editorial = ?, "
                    + "cop_edicion = ?, "
                    + "cop_nPaginas = ?, "
                    + "cop_tipo = ?, "
                    + "cop_categoriaMulta = ?, "
                    + "cop_condicion = ?, "
                    + "cop_yearPublicacion = ?, "
                    + "cop_ISBN = ? "
                    + "WHERE cop_titulo = ? AND cop_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cop.getEditorial().getEdiCod());
            stmt.setInt(2, cop.getCopEdicion());
            stmt.setInt(3, cop.getCopPaginas());
            stmt.setString(4, cop.getCopTipo());
            stmt.setString(5, cop.getCategoriaMulta().getCamCod());
            stmt.setString(6, cop.getCondicion().getConCodigo());
            stmt.setString(7, cop.getCopYearPublicacion());
            stmt.setString(8, cop.getCopISBN());
            stmt.setInt(9, cop.getCopTitulo());
            stmt.setInt(10, cop.getCopCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CopiaDAO.updateCopia", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteCopia(Copia cop) {
        PreparedStatement stmt = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "DELETE FROM copia WHERE cop_titulo = ? AND cop_cod = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cop.getCopTitulo());
            stmt.setInt(2, cop.getCopCod());

            stmt.executeUpdate();

            String sqlca = "DELETE FROM copia_autor WHERE cop_titulo = ? AND cop_cod = ?";
            pstmt = conn.prepareStatement(sqlca);
            stmt.setInt(1, cop.getCopTitulo());
            stmt.setInt(2, cop.getCopCod());

            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("CopiaDAO.deleteCopia", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public static List<Copia> listarCopias(Connection conn,  int copTitulo) {
        List<Copia> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM copia c, editorial e, categoria_multa cm, condicion cd, titulo t "
                    + "WHERE c.cop_editorial = e.edi_cod AND "
                    + "c.cop_categoriaMulta = cm.cam_cod AND"
                    + " c.cop_titulo = t.tit_cod AND  "
                    + "c.cop_condicion = cd.con_codigo AND"
                    + " c.cop_titulo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, copTitulo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Copia cop = new Copia();
                Editorial edi = new Editorial();
                CategoriaMulta cm = new CategoriaMulta();
                Condicion con = new Condicion();
                
                //Recoleccion datos titulo
                cop.setCopNombre("tit_nombre");

                // Recoleccion datos Editorial
                edi.setEdiCod(rs.getInt("edi_cod"));
                edi.setEdiNombre(rs.getString("edi_nombre"));

                // Recoleccion datos CategoriaMulta
                cm.setCamCod(rs.getString("cam_cod"));
                cm.setCamNombre(rs.getString("cam_nombre"));
                cm.setCamDescripcion(rs.getString("cam_descripcion"));

                // Recoleccion datos Condicion
                con.setConCodigo(rs.getString("con_codigo"));
                con.setConDescripcion(rs.getString("con_descripcion"));

                // Asignacion Datos a copia
                cop.setCopTitulo(rs.getInt("cop_titulo"));
                cop.setCopCod(rs.getInt("cop_cod"));
                cop.setEditorial(edi);
                cop.setCopEdicion(rs.getInt("cop_edicion"));
                cop.setCopPaginas(rs.getInt("cop_nPaginas"));
                cop.setCopTipo(rs.getString("cop_tipo"));
                cop.setCategoriaMulta(cm);
                cop.setCondicion(con);
                cop.setCopYearPublicacion(rs.getString("cop_yearPublicacion"));
                cop.setCopISBN(rs.getString("cop_ISBN"));

                lista.add(cop);
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
