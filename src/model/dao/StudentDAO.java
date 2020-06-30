package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author luan
 */
public class StudentDAO {

    private Connection connection;
    
    public StudentDAO() throws SQLException {
        this.connection = ConnectionDAO.getConnection();
    }

    
    public void insert(Student student) throws SQLException {
        
        String sql = "INSERT INTO student (name, cpf, sex, birthday, address, telephone, email) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getCpf());
        stmt.setString(3, student.getSex());
        stmt.setString(4, student.getBirthday());
        stmt.setString(5, student.getAddress());
        stmt.setString(6, student.getTelephone());
        stmt.setString(7, student.getEmail());
        
        stmt.execute();
        stmt.close();
    }
    
    public void update(Student student) throws SQLException {
        
        String sql = "UPDATE student SET name=?, cpf=?, sex=?, birthday=?, address=?, telephone=?,"
                + " email=? WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(8, student.getId());
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getCpf());
        stmt.setString(3, student.getSex());
        stmt.setString(4, student.getBirthday());
        stmt.setString(5, student.getAddress());
        stmt.setString(6, student.getTelephone());
        stmt.setString(7, student.getEmail());
                
        stmt.execute();
        stmt.close();
    }
    
    public void delete(int id) throws SQLException {
        
        String sql = "DELETE FROM student WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    } 
    
    public List<Student> select(String name) throws SQLException {
    
        String sql = "SELECT * FROM student WHERE name LIKE ?";
        PreparedStatement stmt = connection.prepareCall(sql);
            
        stmt.setString(1, name);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Student> list = new ArrayList<>();
        
        while (rs.next()) {
            Student student = new Student();
            
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setCpf(rs.getString("cpf"));
            student.setSex(rs.getString("sex"));
            student.setBirthday(rs.getString("birthday"));
            student.setAddress(rs.getString("address"));
            student.setTelephone(rs.getString("telephone"));
            student.setEmail(rs.getString("email"));
            
            list.add(student);
        }
        
        rs.close();
        stmt.close();
        
        return list;
        
    }
    
}
