package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.Loan;
import model.Student;
import model.dao.LoanDAO;
import view.LoanView;
import model.dao.BookDAO;

/**
 *
 * @author luan
 */
public class LoanController {

    private LoanView view;
    private Loan model;
    private LoanDAO dao;
    private BookDAO bookDAO;
    private Book book;

    public LoanController(LoanView view) {
        this.view = view;
    }

    public void add() {
        if (view.checksData()) {

            model = new Loan();

            model.setIdStudent(Integer.parseInt(view.getTxtIdStudent().getText()));
            model.setIdBook(Integer.parseInt(view.getTxtIdBook().getText()));
            model.setLoanDate(view.loanDate());
            model.setReturnDate(view.returnDate());

            try {
                dao = new LoanDAO();

                dao.insert(model);
                this.changesAvailability("no");

                view.showMessage("Successful Loan");
                view.cleanFields();
                view.disableFields();

                this.showList();
                this.showStudentList();
                this.showBookList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when making Loan");
            }

        } else {
            view.showMessage("Fill all Data");
        }
    }

    public void delete() {
        if (view.showConfirm("Delete registration?")) {

            model = new Loan();

            model.setId(Integer.parseInt(view.getTxtId().getText()));

            try {
                dao = new LoanDAO();

                dao.delete(model.getId());
                this.changesAvailability("yes");

                view.showMessage("Deleted Successfully");
                view.cleanFields();
                view.disableFields();

                this.showList();
                this.showStudentList();
                this.showBookList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when delete Register");
            }

        }
    }

    public void giveBack() {
        if (view.showConfirm("Confirm book return?")) {

            model = new Loan();

            model.setId(Integer.parseInt(view.getTxtId().getText()));

            try {
                dao = new LoanDAO();

                dao.delete(model.getId());
                this.changesAvailability("yes");

                view.showMessage("Book successfully Returned");
                view.cleanFields();
                view.disableFields();

                this.showList();
                this.showStudentList();
                this.showBookList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when returning Book");
            }

        }
    }

    public void changesAvailability(String status) throws SQLException {
        bookDAO = new BookDAO();
        book = new Book();

        book.setId(Integer.parseInt(view.getIdBook()));
        book.setAvailable(status);

        bookDAO.updateAvailability(book);

    }

    public void fillInData() {

        int selectedLine = view.getTblLoans().getSelectedRow();

        if (selectedLine != -1) {

            view.fillsFields(
                    view.getTblSearch().getValueAt(selectedLine, 0).hashCode(),
                    view.getTblSearch().getValueAt(selectedLine, 1).hashCode(),
                    view.getTblSearch().getValueAt(selectedLine, 2).hashCode(),
                    view.getTblSearch().getValueAt(selectedLine, 3).toString().replace("-", ""),
                    view.getTblSearch().getValueAt(selectedLine, 4).toString().replace("-", "")
            );
        }

        view.enableFields();
    }

    public void fillStudentData() {

        int selectedLine = view.getTblSearchStudent().getSelectedRow();

        if (selectedLine != -1) {

            view.fillStudentFields(
                    view.getTblSearchStudent().getValueAt(selectedLine, 0).hashCode()
            );
        }

        view.enableFields();
    }

    public void fillBookData() {

        int selectedLine = view.getTblSearchBook().getSelectedRow();

        if (selectedLine != -1) {
            
            if (view.getTblSearchBook().getValueAt(selectedLine, 3).equals("yes")) {
                view.fillBookFields(
                        view.getTblSearchBook().getValueAt(selectedLine, 0).hashCode()
                );
            } else {
                view.showMessage("book Unavailable");
            }
        }

        view.enableFields();
    }

    public void showStudentList() {
        List<Student> student;

        try {
            dao = new LoanDAO();

            String name = "%" + view.getTxtTitleSearch().getText() + "%";

            student = dao.selectStudent(name);

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
            view.showMessage("Error when list Students");
        }

    }

    public void showBookList() {
        List<Book> book;

        try {
            dao = new LoanDAO();

            String title = "%" + view.getTxtTitleSearch().getText() + "%";

            book = dao.selectBook(title);

            if (!book.isEmpty()) {

                String[] line = new String[]{null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblSearchBook().getModel();
                data.setNumRows(0);

                for (int i = 0; i < book.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(book.get(i).getId(), i, 0);
                    data.setValueAt(book.get(i).getTitle(), i, 1);
                    data.setValueAt(book.get(i).getAuthor(), i, 2);
                    data.setValueAt(book.get(i).getAvailable(), i, 3);
                }

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Books");
        }
    }

    public void showList() {
        List<Loan> loan;

        try {
            dao = new LoanDAO();

            loan = dao.select();

            if (!loan.isEmpty()) {

                String[] line = new String[]{null, null, null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblLoans().getModel();
                data.setNumRows(0);

                for (int i = 0; i < loan.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(loan.get(i).getId(), i, 0);
                    data.setValueAt(loan.get(i).getIdStudent(), i, 1);
                    data.setValueAt(loan.get(i).getIdBook(), i, 2);
                    data.setValueAt(loan.get(i).getLoanDate(), i, 3);
                    data.setValueAt(loan.get(i).getReturnDate(), i, 4);
                }

            }

        } catch (SQLException e) {
            view.showMessage("Error when list Loans");
        }
    }
}
