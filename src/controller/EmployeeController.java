package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.dao.EmployeeDAO;
import view.EmployeeView;

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
            if (view.checkPasswords()) {

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
                    view.cleanFields();
                    
                    this.showList();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    view.showMessage("Error when registering Employee");
                }

            } else {
                view.showMessage("Error: Different Passwords");
            }

        } else {
            view.showMessage("Fill all Data!");
        }

    }

    public void showList() {
        List<Employee> employee;

        try {
            dao = new EmployeeDAO();

            employee = dao.list();

            if (!employee.isEmpty()) {

                String[] line = new String[]{null, null, null, null, null, null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblSearch().getModel();
                data.setNumRows(0);

                for (int i = 0; i < employee.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(employee.get(i).getId(), i, 0);
                    data.setValueAt(employee.get(i).getName(), i, 1);
                    data.setValueAt(employee.get(i).getCpf(), i, 2);
                    data.setValueAt(employee.get(i).getSex(), i, 3);
                    data.setValueAt(employee.get(i).getBirthday(), i, 4);
                    data.setValueAt(employee.get(i).getTelephone(), i, 5);
                    data.setValueAt(employee.get(i).getAddress(), i, 6);
                    data.setValueAt(employee.get(i).getUsername(), i, 7);
                }

            } else {
                view.showMessage("No Record Found");
            }
            
        } catch (SQLException e) {
            view.showMessage("Error when list Employee");
        }

    }

}
