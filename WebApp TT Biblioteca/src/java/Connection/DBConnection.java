package Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection getConexion() {
        Connection connection = null;

        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName("sql5.freemysqlhosting.net");
//        dataSource.setDatabaseName("sql554789");
//        dataSource.setUser("sql554789");
//        dataSource.setPassword("nS6*bD1*");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("sql554789");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

}
