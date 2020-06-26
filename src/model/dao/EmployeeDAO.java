package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
