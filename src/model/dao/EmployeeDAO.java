package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author luan
 */
public class EmployeeDAO {
    
    private Connection connection;

    public EmployeeDAO() throws SQLException {
        this.connection = ConnectionDAO.getConnection();
    }
    
    public void insert(Employee employee) throws SQLException {
        
        String sql = "INSERT INTO employee (name, cpf, sex, birthday, address, telephone, username, password) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, md5(?))";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getCpf());
        stmt.setString(3, employee.getSex());
        stmt.setString(4, employee.getBirthday());
        stmt.setString(5, employee.getAddress());
        stmt.setString(6, employee.getTelephone());
        stmt.setString(7, employee.getUsername());
        stmt.setString(8, employee.getPassword());
        
        stmt.execute();
        stmt.close();
    }
    
    public void update(Employee employee) throws SQLException {
        
        String sql = "UPDATE employee SET name=?, cpf=?, sex=?, birthday=?, address=?, telephone=?,"
                + " username=?, password=md5(?) WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(9, employee.getId());
        stmt.setString(1, employee.getName());
        stmt.setString(2, employee.getCpf());
        stmt.setString(3, employee.getSex());
        stmt.setString(4, employee.getBirthday());
        stmt.setString(5, employee.getAddress());
        stmt.setString(6, employee.getTelephone());
        stmt.setString(7, employee.getUsername());
        stmt.setString(8, employee.getPassword());
                
        stmt.execute();
        stmt.close();
    }
    
    public void delete(int id) throws SQLException {
        
        String sql = "DELETE FROM employee WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    } 
    
    public List<Employee> select(String name) throws SQLException {
    
        String sql = "SELECT * FROM employee WHERE name LIKE ?";
        PreparedStatement stmt = connection.prepareCall(sql);
            
        stmt.setString(1, name);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Employee> list = new ArrayList<>();
        
        while (rs.next()) {
            Employee employee =  new Employee();
            
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setCpf(rs.getString("cpf"));
            employee.setSex(rs.getString("sex"));
            employee.setBirthday(rs.getString("birthday"));
            employee.setAddress(rs.getString("address"));
            employee.setTelephone(rs.getString("telephone"));
            employee.setUsername(rs.getString("username"));
            
            list.add(employee);
        }
        
        rs.close();
        stmt.close();
        
        return list;
        
    }
    
}
