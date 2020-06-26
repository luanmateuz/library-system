package model;

/**
 *
 * @author luan
 */
public class Employee extends Person {
    
    private String username;
    private String password;

    public Employee() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
