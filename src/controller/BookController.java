package controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.dao.BookDAO;
import view.BookView;

/**
 *
 * @author luan
 */
public class BookController {

    private BookView view;
    private Book model;
    private BookDAO dao;

    public BookController(BookView view) {
        this.view = view;
    }

    public void add() {
        if (view.checksData()) {

            model = new Book();

            model.setTitle(view.getTxtTitle().getText());
            model.setAuthor(view.getTxtAuthor().getText());
            model.setEdition(view.getTxtEdition().getText());
            model.setYear(view.getTxtYear().getText());
            model.setAvailable(view.getCmbAvailable().getSelectedItem().toString());

            try {
                dao = new BookDAO();

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
            view.showMessage("Fill all Data");
        }
    }

    public void alter() {
        if (view.checksData()) {

            if (view.showConfirm("Confirm change of registration?")) {
                model = new Book();

                model.setId(Integer.parseInt(view.getTxtId().getText()));
                model.setTitle(view.getTxtTitle().getText());
                model.setAuthor(view.getTxtAuthor().getText());
                model.setEdition(view.getTxtEdition().getText());
                model.setYear(view.getTxtYear().getText());
                model.setAvailable(view.getCmbAvailable().getSelectedItem().toString());

                try {
                    dao = new BookDAO();

                    dao.update(model);

                    view.showMessage("Altered Successfully");
                    view.cleanFields();
                    view.disableFields();

                    this.showList();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    view.showMessage("Error when registering Book");
                }
            }
        } else {
            view.showMessage("Fill all Data");
        }
    }

    public void delete() {
        if (view.showConfirm("Delete registration?")) {

            model = new Book();

            model.setId(Integer.parseInt(view.getTxtId().getText()));

            try {
                dao = new BookDAO();

                dao.delete(model.getId());

                view.showMessage("Deleted Successfully");
                view.cleanFields();
                view.disableFields();

                this.showList();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                view.showMessage("Error when delete Book");
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
                    view.getTblSearch().getValueAt(selectedLine, 4).toString(),
                    view.getTblSearch().getValueAt(selectedLine, 5).toString()
            );
        }

        view.enableFields();
    }

    public void showList() {
        List<Book> book;

        try {
            dao = new BookDAO();

            String title = "%" + view.getTxtTitleSearch().getText() + "%";

            book = dao.select(title);

            if (!book.isEmpty()) {

                String[] line = new String[]{null, null, null, null, null, null};

                DefaultTableModel data = (DefaultTableModel) view.getTblSearch().getModel();
                data.setNumRows(0);

                for (int i = 0; i < book.size(); i++) {
                    data.addRow(line);
                    data.setValueAt(book.get(i).getId(), i, 0);
                    data.setValueAt(book.get(i).getTitle(), i, 1);
                    data.setValueAt(book.get(i).getAuthor(), i, 2);
                    data.setValueAt(book.get(i).getEdition(), i, 3);
                    data.setValueAt(book.get(i).getYear(), i, 4);
                    data.setValueAt(book.get(i).getAvailable(), i, 5);
                }

            } 

        } catch (SQLException e) {
            view.showMessage("Error when list Student");
        }

    }
}
