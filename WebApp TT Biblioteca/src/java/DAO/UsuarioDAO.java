package DAO;

import Connection.DBConnection;
import POJO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Connection conn = DBConnection.getConexion();

    public void insertUsuario(Usuario usr) {
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INO usuario VALUES (?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usr.getUsrRut());
            stmt.setString(2, usr.getUsrDv());
            stmt.setString(3, usr.getUsrNombres());
            stmt.setString(4, usr.getUsrPriApellido());
            stmt.setString(5, usr.getUsrSecApellido());
            stmt.setString(6, usr.getUsrFono());
            stmt.setString(7, usr.getUsrTipoCuenta());
            stmt.setString(8, usr.getUsrPass());
            stmt.setString(9, usr.getUsrEstado());
            stmt.setInt(10, usr.getUsrMulta());

            stmt.executeUpdate();
            if (usr.getCurso() != null) {
                PreparedStatement pstmt = null;
                try {
                    String sqlic = "INSERT INTO usuario_curso VALUES (?,?,?)";
                    pstmt = conn.prepareStatement(sqlic);
                    pstmt.setInt(1, usr.getUsrRut());
                    pstmt.setString(2, usr.getUsrDv());
                    pstmt.setString(3, usr.getCurso().getCurCodigo());

                    pstmt.executeUpdate();
                } catch (Exception ex) {
                    throw new RuntimeException("UsuarioDAO.insertUsuarioCurso", ex);
                } finally {
                    try {
                        pstmt.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("UsuarioDAO.insertUsuario", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateUsuario(Usuario usr) {
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE usuario SET "
                    + "usr_nombres = ?, "
                    + "usr_priApellido = ?, "
                    + "usr_secApellido = ?, "
                    + "usr_fono = ?, "
                    + "usr_tipoCuenta = ?, "
                    + "usr_estado = ?"
                    + "WHERE usr_rut = ? AND usr_dv = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usr.getUsrNombres());
            stmt.setString(2, usr.getUsrPriApellido());
            stmt.setString(3, usr.getUsrSecApellido());
            stmt.setString(4, usr.getUsrFono());
            stmt.setString(5, usr.getUsrTipoCuenta());
            stmt.setString(6, usr.getUsrEstado());
            stmt.setInt(7, usr.getUsrRut());
            stmt.setString(8, usr.getUsrDv());

            stmt.executeUpdate();
            if (usr.getCurso() != null) {
                PreparedStatement pstmt = null;
                try {
                    String sqluc = "UPDATE usuario_curso SET"
                            + "curso = ?"
                            + "WHERE rut = ? AND dv = ?";
                    pstmt = conn.prepareStatement(sqluc);
                    pstmt.setString(1, usr.getCurso().getCurCodigo());
                    pstmt.setInt(2, usr.getUsrRut());
                    pstmt.setString(3, usr.getUsrDv());
                    
                    pstmt.executeUpdate();
                } catch (Exception e) {
                    throw new RuntimeException("UsuarioDAO.updateUsuarioCurso", e);
                }finally{
                    try {
                        pstmt.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("UsuarioDAO.updateUsuario", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteUsuario(Usuario usr) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM usuario WHERE usr_rut = ? AND usr_dv = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usr.getUsrRut());
            stmt.setString(2, usr.getUsrDv());

            stmt.executeUpdate();
            if (usr.getCurso() != null) {
                PreparedStatement pstmt = null;
                try {
                    String sqldc = "DELETE FROM usuario_curso WHERE rut = ? AND dv = ?";
                    pstmt = conn.prepareStatement(sqldc);
                    pstmt.setInt(1, usr.getUsrRut());
                    pstmt.setString(2, usr.getUsrDv());

                    pstmt.executeUpdate();
                } catch (Exception ex) {
                    throw new RuntimeException("UsuarioDAO.deleteUsuarioCurso", ex);
                } finally {
                    try {
                        pstmt.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("UsuarioDAO.deleteUsuario", ex);
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                Object o = new Object();
//                
//                lista.add(o);
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
