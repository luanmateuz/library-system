package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author luan
 */
public class BookDAO {

    private Connection connection;

    public BookDAO() throws SQLException {
        this.connection = ConnectionDAO.getConnection();
    }
    
    public void insert(Book book) throws SQLException {
        
        String sql = "INSERT INTO book (title, author, edition, year, available) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setString(3, book.getEdition());
        stmt.setString(4, book.getYear());
        stmt.setString(5, book.getAvailable());
        
        stmt.execute();
        stmt.close();
    }
    
    public void update(Book book) throws SQLException {
        
        String sql = "UPDATE book SET title=?, author=?, edition=?, year=?, available=? WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(6, book.getId());
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setString(3, book.getEdition());
        stmt.setString(4, book.getYear());
        stmt.setString(5, book.getAvailable());
        
        stmt.execute();
        stmt.close();
    }
    
    public void updateAvailability(Book book) throws SQLException {
        
        String sql = "UPDATE book SET available=? WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setString(1, book.getAvailable());
        stmt.setInt(2, book.getId());
        
        stmt.execute();
        stmt.close();
    }
    
    public void delete(int id) throws SQLException {
        
        String sql = "DELETE FROM book WHERE id=?";
        
        PreparedStatement stmt = connection.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
    } 
    
    public List<Book> select(String title) throws SQLException {
    
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