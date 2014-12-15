/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCD;

import Connection.DBConnection;
import DAO.DeweyDAO;
import DAO.EditorialDAO;
import POJO.Dewey;
import POJO.Editorial;
import java.sql.Connection;

/**
 *
 * @author Niko
 */
public class EditorialFCD {

   

        public static void insertEditorial(Editorial editorial) {
            Connection conn = DBConnection.getConexion();
            EditorialDAO.insertEditorial(conn, editorial);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        public static void updateEditorial(Editorial editorial) {
            Connection conn = DBConnection.getConexion();
            EditorialDAO.updateEditorial(conn, editorial);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }

        public static void deleteEditorial(Editorial editorial) {
            Connection conn = DBConnection.getConexion();
            EditorialDAO.deleteEditorial(conn, editorial);
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
