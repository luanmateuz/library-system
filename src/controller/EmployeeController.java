package controller;

import java.sql.SQLException;
import model.Employee;
import model.dao.EmployeeDAO;
import view.register.EmployeeView;

/**
 *
 * @author luan
 */
public class EmployeeController {

    private EmployeeView view;
    private Employee model;
    private EmployeeDAO dao;

    public EmployeeController(EmployeeView view) {
        this.view = view;
    }

    public void add() {

        if (view.checksData()) {
            
            model = new Employee();

            model.setName(view.getTxtName().getText());
            model.setCpf(view.getTxtCPF().getText().replace(".", "").replace("-", ""));
            model.setSex(view.getCmbSex().getSelectedItem().toString());
            model.setBirthday(view.getTxtBirthday().getText().replace("/", "-"));
            model.setAddress(view.getTxtAddress().getText());
            model.setTelephone(view.getTxtTelephone().getText().replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
            model.setUsername(view.getTxtUsername().getText());
            model.setPassword(new String(view.getPwdPassword().getPassword()));
            
            try {
                dao = new EmployeeDAO();

                dao.insert(model);

                view.showMessage("Registered Successfully");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when registering Employee");
            }
        } else {
            view.showMessage("Fill all Data!");
        }

    }

}
