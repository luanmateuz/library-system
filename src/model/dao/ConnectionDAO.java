package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luan
 */
public class ConnectionDAO {

    public static Connection getConnection() throws SQLException {
        
        try {
            String databaseName = "jdbc:mysql://localhost/library_system";
            String databaseUser = "root";
            String databasePassword = "toor";
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection(databaseName, databaseUser, databasePassword);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }
}
