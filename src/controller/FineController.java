package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Fine;
import model.Student;
import model.dao.FineDAO;
import model.dao.StudentDAO;
import view.FineView;

/**
 *
 * @author luan
 */
public class FineController {

    private FineView view;
    private Fine model;
    private FineDAO dao;
    private StudentDAO studentDAO;

    public FineController(FineView view) {
        this.view = view;
    }

    public void add() {
        if (view.checksData()) {
            model = new Fine();

            model.setIdStudent(Integer.valueOf(view.getTxtIdStudent().getText()));
            model.setDescription(view.getCmbDescription().getSelectedItem().toString());
            model.setValue(Float.valueOf(view.getTxtValue().getText()));

            try {
                dao = new FineDAO();

                dao.insert(model);

                view.showMessage("Fined Student");
                view.cleanFields();
                view.disableFields();

                this.showList();
                this.showFinesList();
            } catch (SQLException e) {
                view.showMessage("Error");
                System.out.println("Error => " + e.getMessage());
            }
        } else {
            view.showMessage("Fill all Data!");
        }
    }
    
    public void pay() {
        if (view.showConfirm("Confirm Payment?")) {
            
            int idStudent = Integer.valueOf(view.getTxtIdStudent().getText());
            
            try {
                dao = new FineDAO();

                dao.deleteFines(idStudent);

                view.showMessage("Successful Payment");
                view.cleanFields();
                view.disableFields();

                this.showList();
                this.showFinesList();
            } catch (SQLException e) {
                view.showMessage("Error");
                System.out.println("Error => " + e.getMessage());
            }
        } 
    }

    public void delete() {
        if (view.showConfirm("To Delete a Fine?")) {
            
            int selectedLine = view.getTblFines().getSelectedRow();

            if (selectedLine != -1) {

                int id = view.getTblFines().getValueAt(selectedLine, 0).hashCode();

                try {
                    dao = new FineDAO();

                    dao.delete(id);

                    view.showMessage("Deleted Successfully");
                    view.cleanFields();
                    view.disableFields();

                    this.showList();
                    this.showFinesList();
                } catch (SQLException ex) {
                    System.out.println("erro => " + ex.getMessage());
                }
            }
            
        }

    }

    public void fillInData() {

        int selectedLine = view.getTblSearchStudent().getSelectedRow();

        if (selectedLine != -1) {

            try {
                dao = new FineDAO();

                view.fillsFields(
                        view.getTblSearchStudent().getValueAt(selectedLine, 0).hashCode(),
                        view.getTblSearchStudent().getValueAt(selectedLine, 1).toString(),
                        dao.totalStudentFines(view.getTblSearchStudent().getValueAt(selectedLine, 0).hashCode())
                );

            } catch (SQLException ex) {
                view.showMessage("Error when fill data");
                System.out.println(ex.getMessage());
            }
        }

        view.enableFields();
    }

    public void showList() {
        List<Student> student;

        try {
            studentDAO = new StudentDAO();

            String name = "%" + view.txtStudentSearch().getText() + "%";

            student = studentDAO.select(name);

            if (!student.isEmpty()) {

                String[] line = new String[]{null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblSearchStudent().getModel();
                data.setNumRows(0);

                for (int i = 0; i < student.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(student.get(i).getId(), i, 0);
                    data.setValueAt(student.get(i).getName(), i, 1);
                    data.setValueAt(student.get(i).getCpf(), i, 2);
                }

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Student");
        }

    }

    public void showFinesList() {
        List<Fine> fine;

        try {
            dao = new FineDAO();

            fine = dao.select();

            if (!fine.isEmpty()) {

                String[] line = new String[]{null, null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblFines().getModel();
                data.setNumRows(0);

                for (int i = 0; i < fine.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(fine.get(i).getId(), i, 0);
                    data.setValueAt(fine.get(i).getIdStudent(), i, 1);
                    data.setValueAt(fine.get(i).getDescription(), i, 2);
                    data.setValueAt(fine.get(i).getValue(), i, 3);
                }

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Student");
        }

    }

}
