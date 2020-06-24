package controller;

import view.LoginView;
import model.dao.LoginDAO;

/**
 *
 * @author luan
 */
public class LoginController {

    private final LoginView view;
    private final LoginDAO dao;

    public LoginController(LoginView view) {
        this.view = view;
        this.dao = new LoginDAO();
    }
    
    public void enterSystem() {
        String username = view.getUsername();
        String password = view.getPassword();
        
        boolean login = dao.makeLogin(username, password);
        
        if (login) {
            System.out.println("window main");
            view.dispose();
        } else {
            view.showMessage("Username or Password invalid!");
        }
        
    }
    
}
