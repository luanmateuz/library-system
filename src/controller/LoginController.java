package controller;

import view.LoginView;
import view.MainView;
import model.dao.LoginDAO;

/**
 *
 * @author luan
 */
public class LoginController {

    private final LoginView view;
    private final MainView main;
    private final LoginDAO dao;

    public LoginController(LoginView view) {
        this.view = view;
        this.main = new MainView();
        this.dao = new LoginDAO();
    }
    
    public void enterSystem() {
        String username = view.getUsername();
        String password = view.getPassword();
        
        boolean login = dao.makeLogin(username, password);
        
        if (login) {
            main.setVisible(true);
            view.dispose();
        } else {
            view.showMessage("Username or Password invalid!");
        }
        
    }
    
}
