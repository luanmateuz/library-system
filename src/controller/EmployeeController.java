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
                    view.disableFields();

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

    public void alter() {
        if (view.checksData()) {
            if (view.checkPasswords()) {

                if (view.showConfirm("Confirm change of registration?")) {

                    model = new Employee();

                    model.setId(Integer.parseInt(view.getTxtId().getText()));
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

                        dao.update(model);

                        view.showMessage("Altered Successfully");
                        view.cleanFields();
                        view.disableFields();

                        this.showList();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        view.showMessage("Error when registering Employee");
                    }
                }

            } else {
                view.showMessage("Error: Different Passwords");
            }

        } else {
            view.showMessage("Fill all Data!");
        }

    }

    public void delete() {
        if (view.showConfirm("Delete registration?")) {

            model = new Employee();

            model.setId(Integer.parseInt(view.getTxtId().getText()));

            try {
                dao = new EmployeeDAO();

                dao.delete(model.getId());

                view.showMessage("Deleted Successfully");
                view.cleanFields();
                view.disableFields();

                this.showList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when delete Employee");
            }

        }
    }

    public void fillInData() {

        int selectedLine = view.getTblSearch().getSelectedRow();

        if (selectedLine != -1) {

            view.fillsFields(
                    view.getTblSearch().getValueAt(selectedLine, 0).hashCode(),
                    view.getTblSearch().getValueAt(selectedLine, 1).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 2).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 3).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 4).toString().replace("-", ""),
                    view.getTblSearch().getValueAt(selectedLine, 5).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 6).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 7).toString()
            );
        }

        view.enableFields();
    }

    public void showList() {
        List<Employee> employee;

        try {
            dao = new EmployeeDAO();
            
            String name = "%" + view.getTxtNameSearch().getText() + "%";

            employee = dao.select(name);

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

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Employee");
        }

    }

}
