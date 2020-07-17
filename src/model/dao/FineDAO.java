package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fine;

/**
 *
 * @author luan
 */
public class FineDAO {
    
    private Connection connection;
    
    public FineDAO() throws SQLException {
        this.connection = ConnectionDAO.getConnection();
    }
    
    public void insert(Fine fine) throws SQLException {
        
        String sql = "INSERT INTO fines (id_student, description, value) "
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, fine.getIdStudent());
        stmt.setString(2, fine.getDescription());
        stmt.setFloat(3, fine.getValue());
        
        stmt.execute();
        stmt.close();
    }
    
    public void delete(int id) throws SQLException {
        
        String sql = "DELETE FROM fines WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    }
    
    public void deleteFines(int id) throws SQLException {
        
        String sql = "DELETE FROM fines WHERE id_student=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    }
    
    public List<Fine> select() throws SQLException {
    
        String sql = "SELECT * FROM fines";
        PreparedStatement stmt = connection.prepareCall(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Fine> list = new ArrayList<>();
        
        while (rs.next()) {
            Fine fine = new Fine();
            
            fine.setId(rs.getInt("id"));
            fine.setIdStudent(rs.getInt("id_student"));
            fine.setDescription(rs.getString("description"));
            fine.setValue(rs.getFloat("value"));
            
            list.add(fine);
        }
        
        rs.close();
        stmt.close();
        
        return list;
        
    }
   
    public String totalStudentFines(int idStudent) throws SQLException {
        
        String sql = "SELECT SUM(fines.value) AS totalValue "
                + "FROM fines "
                + "WHERE id_student = ?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idStudent);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        
        String totalFine = String.valueOf(rs.getFloat("totalValue"));
                
        stmt.execute();
        stmt.close();
        
        return totalFine;
    }
    
}
