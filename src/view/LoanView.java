package view;

import controller.LoanController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author luan
 */
public class LoanView extends javax.swing.JFrame {
    
    private LoanController controller;
    
    public LoanView() {
        this.initComponents();
        this.disableFields();
        this.cleanFields();
        controller = new LoanController(this);
        controller.showStudentList();
        controller.showBookList();
        controller.showList();
    }
    
    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtIdStudent() {
        return txtIdStudent;
    }

    public void setTxtIdStudent(JTextField txtIdStudent) {
        this.txtIdStudent = txtIdStudent;
    }

    public JTextField getTxtIdBook() {
        return txtIdBook;
    }

    public void setTxtIdBook(JTextField txtIdBook) {
        this.txtIdBook = txtIdBook;
    }

    public JFormattedTextField getTxtLoanDate() {
        return txtLoanDate;
    }

    public void setTxtLoanDate(JFormattedTextField txtLoanDate) {
        this.txtLoanDate = txtLoanDate;
    }

    public JFormattedTextField getTxtReturnDate() {
        return txtReturnDate;
    }

    public void setTxtReturnDate(JFormattedTextField txtReturnDate) {
        this.txtReturnDate = txtReturnDate;
    } 

    public JTextField getTxtTitleSearch() {
        return txtTitleSearch;
    }

    public void setTxtTitleSearch(JTextField txtTitleSearch) {
        this.txtTitleSearch = txtTitleSearch;
    }
    
    public JTable getTblSearch() {
        return tblLoans;
    }

    public void setTblSearch(JTable tblSearch) {
        this.tblLoans = tblSearch;
    }
    
    public void enableFields() {
       txtReturnDate.setEditable(true);
    }
    
    public void disableFields() {
        txtId.setEditable(false);
        txtIdStudent.setEditable(false);
        txtIdBook.setEditable(false);
        txtLoanDate.setEditable(false);
        txtReturnDate.setEditable(false);
        
        btnDelete.setEnabled(false);
        btnReturn.setEnabled(false);
        btnLoan.setEnabled(false);
    }
    
    public void cleanFields() {
        txtId.setText("");
        txtIdStudent.setText("");
        txtIdBook.setText("");
        txtLoanDate.setText(this.loanDate().replace("-", ""));
        txtReturnDate.setText(this.returnDate().replace("-", ""));
    }
    
    public void fillsFields(int id, int idStudent, int idBook, String loanDate, String returnDate) {
        txtId.setText(id+"");
        txtIdStudent.setText(idStudent+"");
        txtIdBook.setText(idBook+"");
        txtLoanDate.setText(loanDate);
        txtReturnDate.setText(returnDate);
    }
    
    public void fillStudentFields(int idStudent) {
        txtIdStudent.setText(idStudent+"");
    }
    
    public void fillBookFields(int idBook) {
        txtIdBook.setText(idBook+"");
    }
    
    public boolean checksData() {
        return !txtIdStudent.getText().equals("") && !txtIdBook.getText().equals("")
                && !txtLoanDate.getText().equals("") && !txtReturnDate.getText().equals("");
    }
       
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public boolean showConfirm(String message) {
        int res = JOptionPane.showConfirmDialog(null, message, "Confirm!", JOptionPane.YES_NO_OPTION);
        
        return res == JOptionPane.YES_NO_OPTION;
    }
    
    public String loanDate() {
        Date date = new Date();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String loanDateFormat = dateFormat.format(date);
        
        return loanDateFormat;
    }
    
    public String returnDate() {
        Date date = new Date();
        date.setDate(date.getDate() + 14);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String returnDateFormat = dateFormat.format(date);
        
        return returnDateFormat;
    }
    
    public String getReturnDate() {
        
        int selectedLine = tblLoans.getSelectedRow();   
        String tableDate = (tblLoans.getValueAt(selectedLine, 4)).toString();
                
        return tableDate;
    }
    
    public String getIdBook() {
        int selectedLine;
        String id = "0";
        
        if (tblLoans.getSelectedRow() != -1) {
            selectedLine = tblLoans.getSelectedRow();
            id = tblLoans.getValueAt(selectedLine, 2).toString();
        }
        
        if (tblSearchBook.getSelectedRow() != -1) {
            selectedLine = tblSearchBook.getSelectedRow();
            id = tblSearchBook.getValueAt(selectedLine, 0).toString();
        }
        
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSearch = new javax.swing.ButtonGroup();
        panSearch = new javax.swing.JPanel();
        lblTitleSearch = new javax.swing.JLabel();
        jrbStudent = new javax.swing.JRadioButton();
        jrbBook = new javax.swing.JRadioButton();
        txtTitleSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoans = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearchStudent = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSearchBook = new javax.swing.JTable();
        panOptions = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnLoan = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        panData = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblIdStudent = new javax.swing.JLabel();
        txtIdStudent = new javax.swing.JTextField();
        lblIdBook = new javax.swing.JLabel();
        txtIdBook = new javax.swing.JTextField();
        lblLoanDate = new javax.swing.JLabel();
        txtLoanDate = new javax.swing.JFormattedTextField();
        lblReturnDate = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan");
        setResizable(false);

        panSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblTitleSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblTitleSearch.setText("Search:");

        btgSearch.add(jrbStudent);
        jrbStudent.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jrbStudent.setText("Student");

        btgSearch.add(jrbBook);
        jrbBook.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jrbBook.setText("Book");

        txtTitleSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(235, 235, 235));
        btnSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblLoans.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblLoans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Student", "ID Book", "Loan Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoansMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoans);

        tblSearchStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblSearchStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSearchStudent);

        tblSearchBook.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblSearchBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearchBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchBookMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSearchBook);

        javax.swing.GroupLayout panSearchLayout = new javax.swing.GroupLayout(panSearch);
        panSearch.setLayout(panSearchLayout);
        panSearchLayout.setHorizontalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panSearchLayout.createSequentialGroup()
                        .addComponent(lblTitleSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbBook)
                        .addGap(37, 37, 37)
                        .addComponent(txtTitleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panSearchLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panSearchLayout.setVerticalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtTitleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitleSearch)
                    .addComponent(jrbStudent)
                    .addComponent(jrbBook))
                .addGap(18, 18, 18)
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        panOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        btnDelete.setBackground(new java.awt.Color(235, 235, 235));
        btnDelete.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 39));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(235, 235, 235));
        btnReturn.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(235, 235, 235));
        btnNew.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnLoan.setBackground(new java.awt.Color(235, 235, 235));
        btnLoan.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnLoan.setText("Loan");
        btnLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanActionPerformed(evt);
            }
        });

        btnQuit.setBackground(new java.awt.Color(235, 235, 235));
        btnQuit.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panOptionsLayout = new javax.swing.GroupLayout(panOptions);
        panOptions.setLayout(panOptionsLayout);
        panOptionsLayout.setHorizontalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panOptionsLayout.setVerticalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOptionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoan)
                .addGap(18, 18, 18)
                .addComponent(btnQuit)
                .addContainerGap())
        );

        panData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblId.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblId.setText("ID:");

        txtId.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblIdStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblIdStudent.setText("ID Student:");

        txtIdStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblIdBook.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblIdBook.setText("ID Book:");

        txtIdBook.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblLoanDate.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblLoanDate.setText("Loan Date:");

        try {
            txtLoanDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtLoanDate.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblReturnDate.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblReturnDate.setText("Return Date:");

        try {
            txtReturnDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtReturnDate.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout panDataLayout = new javax.swing.GroupLayout(panData);
        panData.setLayout(panDataLayout);
        panDataLayout.setHorizontalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdStudent)
                    .addComponent(lblId)
                    .addComponent(lblIdBook)
                    .addComponent(lblLoanDate)
                    .addComponent(lblReturnDate))
                .addGap(113, 113, 113)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoanDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        panDataLayout.setVerticalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdStudent)
                    .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdBook)
                    .addComponent(txtIdBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoanDate)
                    .addComponent(txtLoanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReturnDate)
                    .addComponent(txtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(panData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (jrbStudent.isSelected()) {
            controller.showStudentList();
        } else if (jrbBook.isSelected()) {
            controller.showBookList();
        } else {
            controller.showStudentList();
            controller.showBookList();
        }
    }

    private void tblLoansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoansMouseClicked
        controller.fillInData();
        btnDelete.setEnabled(true);
        btnReturn.setEnabled(true);
        btnLoan.setEnabled(false);
    }//GEN-LAST:event_tblLoansMouseClicked
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        controller.delete();
    }
    
    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {
        controller.giveBack();
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        this.cleanFields();
        this.enableFields();
        btnDelete.setEnabled(false);
        btnReturn.setEnabled(false);
        btnLoan.setEnabled(true);
    }
    
    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
        controller.add();
    }//GEN-LAST:event_btnLoanActionPerformed

    private void tblSearchStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchStudentMouseClicked
        controller.fillStudentData();
    }//GEN-LAST:event_tblSearchStudentMouseClicked

    private void tblSearchBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchBookMouseClicked
        controller.fillBookData();
    }//GEN-LAST:event_tblSearchBookMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public JTable getTblLoans() {
        return tblLoans;
    }

    public void setTblLoans(JTable tblLoans) {
        this.tblLoans = tblLoans;
    }

    public JTable getTblSearchBook() {
        return tblSearchBook;
    }

    public void setTblSearchBook(JTable tblSearchBook) {
        this.tblSearchBook = tblSearchBook;
    }

    public JTable getTblSearchStudent() {
        return tblSearchStudent;
    }

    public void setTblSearchStudent(JTable tblSearchStudent) {
        this.tblSearchStudent = tblSearchStudent;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoanView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton jrbBook;
    private javax.swing.JRadioButton jrbStudent;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdBook;
    private javax.swing.JLabel lblIdStudent;
    private javax.swing.JLabel lblLoanDate;
    private javax.swing.JLabel lblReturnDate;
    private javax.swing.JLabel lblTitleSearch;
    private javax.swing.JPanel panData;
    private javax.swing.JPanel panOptions;
    private javax.swing.JPanel panSearch;
    private javax.swing.JTable tblLoans;
    private javax.swing.JTable tblSearchBook;
    private javax.swing.JTable tblSearchStudent;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdBook;
    private javax.swing.JTextField txtIdStudent;
    private javax.swing.JFormattedTextField txtLoanDate;
    private javax.swing.JFormattedTextField txtReturnDate;
    private javax.swing.JTextField txtTitleSearch;
    // End of variables declaration//GEN-END:variables
}
