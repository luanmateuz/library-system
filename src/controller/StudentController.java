package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Student;
import model.dao.StudentDAO;
import view.StudentView;

/**
 *
 * @author luan
 */
public class StudentController {
    
    private StudentView view;
    private Student model;
    private StudentDAO dao;

    public StudentController(StudentView view) {
        this.view = view;
    }
    
    public void add() {

        if (view.checksData()) {
            if (view.checkPasswords()) {

                model = new Student();

                model.setName(view.getTxtName().getText());
                model.setCpf(view.getTxtCPF().getText().replace(".", "").replace("-", ""));
                model.setSex(view.getCmbSex().getSelectedItem().toString());
                model.setBirthday(view.getTxtBirthday().getText().replace("/", "-"));
                model.setAddress(view.getTxtAddress().getText());
                model.setTelephone(view.getTxtTelephone().getText().replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
                model.setEmail(view.getTxtEmail().getText());

                try {
                    dao = new StudentDAO();

                    dao.insert(model);

                    view.showMessage("Registered Successfully");
                    view.cleanFields();
                    view.disableFields();

                    this.showList();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    view.showMessage("Error when registering Student");
                }

            } else {
                view.showMessage("Error: Different Emails");
            }

        } else {
            view.showMessage("Fill all Data!");
        }

    }

    public void alter() {
        if (view.checksData()) {
            if (view.checkPasswords()) {

                if (view.showConfirm("Confirm change of registration?")) {

                    model = new Student();

                    model.setId(Integer.parseInt(view.getTxtId().getText()));
                    model.setName(view.getTxtName().getText());
                    model.setCpf(view.getTxtCPF().getText().replace(".", "").replace("-", ""));
                    model.setSex(view.getCmbSex().getSelectedItem().toString());
                    model.setBirthday(view.getTxtBirthday().getText().replace("/", "-"));
                    model.setAddress(view.getTxtAddress().getText());
                    model.setTelephone(view.getTxtTelephone().getText().replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
                    model.setEmail(view.getTxtEmail().getText());

                    try {
                        dao = new StudentDAO();

                        dao.update(model);

                        view.showMessage("Altered Successfully");
                        view.cleanFields();
                        view.disableFields();

                        this.showList();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        view.showMessage("Error when registering Student");
                    }
                }

            } else {
                view.showMessage("Error: Different Emails");
            }

        } else {
            view.showMessage("Fill all Data!");
        }

    }

    public void delete() {
        if (view.showConfirm("Delete registration?")) {

            model = new Student();

            model.setId(Integer.parseInt(view.getTxtId().getText()));

            try {
                dao = new StudentDAO();

                dao.delete(model.getId());

                view.showMessage("Deleted Successfully");
                view.cleanFields();
                view.disableFields();

                this.showList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when delete Student");
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
        List<Student> student;

        try {
            dao = new StudentDAO();
            
            String name = "%" + view.getTxtNameSearch().getText() + "%";

            student = dao.select(name);

            if (!student.isEmpty()) {

                String[] line = new String[]{null, null, null, null, null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblSearch().getModel();
                data.setNumRows(0);

                for (int i = 0; i < student.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(student.get(i).getId(), i, 0);
                    data.setValueAt(student.get(i).getName(), i, 1);
                    data.setValueAt(student.get(i).getCpf(), i, 2);
                    data.setValueAt(student.get(i).getSex(), i, 3);
                    data.setValueAt(student.get(i).getBirthday(), i, 4);
                    data.setValueAt(student.get(i).getTelephone(), i, 5);
                    data.setValueAt(student.get(i).getAddress(), i, 6);
                    data.setValueAt(student.get(i).getEmail(), i, 7);
                }

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Student");
        }

    }
}
