package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luan
 */
public class LoginDAO {
    
    public boolean makeLogin(String username, String password) {
        try {
            Connection con = ConnectionDAO.getConnection();
            String sql = "SELECT * FROM employee WHERE username=? AND password=md5(?)";
            
            PreparedStatement stmt = con.prepareCall(sql);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            ResultSet result = stmt.executeQuery();
                        
            return result.next();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return false;
    }
}
