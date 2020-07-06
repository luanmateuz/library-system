package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Loan;
import model.Student;

/**
 *
 * @author luan
 */
public class LoanDAO {

    private Connection connection;

    public LoanDAO() throws SQLException {
        this.connection = ConnectionDAO.getConnection();
    }
    
    public void insert(Loan loan) throws SQLException {
        
        String sql = "INSERT INTO loan (id_student, id_book, loan_date, return_date) "
                + "VALUES (?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, loan.getIdStudent());
        stmt.setInt(2, loan.getIdBook());
        stmt.setString(3, loan.getLoanDate());
        stmt.setString(4, loan.getReturnDate());
        
        stmt.execute();
        stmt.close();
    }
    
    public void delete(int id) throws SQLException {
        
        String sql = "DELETE FROM loan WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    } 
    
    public List<Loan> select() throws SQLException {
    
        String sql = "SELECT * FROM loan";
        PreparedStatement stmt = connection.prepareCall(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Loan> list = new ArrayList<>();
        
        while (rs.next()) {
            Loan loan = new Loan();
            
            loan.setId(rs.getInt("id"));
            loan.setIdStudent(rs.getInt("id_student"));
            loan.setIdBook(rs.getInt("id_book"));
            loan.setLoanDate(rs.getString("loan_date"));
            loan.setReturnDate(rs.getString("return_date"));
            
            list.add(loan);
        }
        
        rs.close();
        stmt.close();
        
        return list;
        
    }
    
    public List<Student> selectStudent(String name) throws SQLException {
    
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
    
    public List<Book> selectBook(String title) throws SQLException {
    
        String sql = "SELECT * FROM book WHERE title LIKE ?";
        PreparedStatement stmt = connection.prepareCall(sql);
            
        stmt.setString(1, title);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Book> list = new ArrayList<>();
        
        while (rs.next()) {
            Book book = new Book();
            
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setEdition(rs.getString("edition"));
            book.setYear(rs.getString("year"));
            book.setAvailable(rs.getString("available"));
            
            list.add(book);
        }
        
        rs.close();
        stmt.close();
        
        return list;
        
    }
}
