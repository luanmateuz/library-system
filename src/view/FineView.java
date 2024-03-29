package view;

import controller.FineController;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author luan
 */
public class FineView extends javax.swing.JFrame {

    private FineController controller;
    
    public FineView() {
        this.initComponents();
        this.disableFields();
        this.cleanFields();
        controller = new FineController(this);
        controller.showList();
        controller.showFinesList();
    }

    public JTable getTblSearchStudent() {
        return tblSearchStudent;
    }

    public void setTblSearchStudent(JTable tblSearchStudent) {
        this.tblSearchStudent = tblSearchStudent;
    }

    public JTextField getTxtIdStudent() {
        return txtIdStudent;
    }

    public void setTxtIdStudent(JTextField txtIdStudent) {
        this.txtIdStudent = txtIdStudent;
    }

    public JTextField getTxtStudent() {
        return txtStudent;
    }

    public void setTxtStudent(JTextField txtStudent) {
        this.txtStudent = txtStudent;
    }

    public JTextField txtStudentSearch() {
        return txtStudentSearch;
    }

    public void setTxtTitleSearch(JTextField txtTitleSearch) {
        this.txtStudentSearch = txtTitleSearch;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    public JTextField getTxtValue() {
        return txtValue;
    }

    public void setTxtValue(JFormattedTextField txtValue) {
        this.txtValue = txtValue;
    }

    public JTable getTblFines() {
        return tblFines;
    }

    public void setTblFines(JTable tblFines) {
        this.tblFines = tblFines;
    }

    public JComboBox<String> getCmbDescription() {
        return cmbDescription;
    }

    public void setCmbDescription(JComboBox<String> cmbDescription) {
        this.cmbDescription = cmbDescription;
    }
        
    public void enableFields() {
       txtValue.setEditable(true);
    }
    
    public void disableFields() {
        txtIdStudent.setEditable(false);
        txtStudent.setEditable(false);
        txtTotal.setEditable(false);
        
        btnDelete.setEnabled(false);
        btnPay.setEnabled(false);
        btnFine.setEnabled(false);
    }
    
    public void cleanFields() {
        txtIdStudent.setText("");
        txtStudent.setText("");
        txtValue.setText("");
        txtTotal.setText("");
    }
    
    public void fillsFields(int idStudent, String Student) {
        txtIdStudent.setText(idStudent+"");
        txtStudent.setText(Student);
    }
    
    public void fillsFields(int idStudent, String Student, String total) {
        txtIdStudent.setText(idStudent+"");
        txtStudent.setText(Student);
        txtTotal.setText(total);
    }
    
    public boolean checksData() {
        return txtValue.getValue() != null;
    }
       
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public boolean showConfirm(String message) {
        int res = JOptionPane.showConfirmDialog(null, message, "Confirm!", JOptionPane.YES_NO_OPTION);
        
        return res == JOptionPane.YES_NO_OPTION;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSearch = new javax.swing.JPanel();
        lblStudentSearch = new javax.swing.JLabel();
        txtStudentSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearchStudent = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFines = new javax.swing.JTable();
        panOptions = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnFine = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        panData = new javax.swing.JPanel();
        lblIdStudent = new javax.swing.JLabel();
        txtIdStudent = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        cmbDescription = new javax.swing.JComboBox<>();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        txtStudent = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fine");
        setResizable(false);

        panSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblStudentSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblStudentSearch.setText("Stutdent:");

        txtStudentSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(235, 235, 235));
        btnSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

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

        tblFines.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblFines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Student", "Description", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
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
        tblFines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFinesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFines);

        javax.swing.GroupLayout panSearchLayout = new javax.swing.GroupLayout(panSearch);
        panSearch.setLayout(panSearchLayout);
        panSearchLayout.setHorizontalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panSearchLayout.createSequentialGroup()
                        .addComponent(lblStudentSearch)
                        .addGap(18, 18, 18)
                        .addComponent(txtStudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addGroup(panSearchLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        panSearchLayout.setVerticalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtStudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStudentSearch))
                .addGap(18, 18, 18)
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnPay.setBackground(new java.awt.Color(235, 235, 235));
        btnPay.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
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

        btnFine.setBackground(new java.awt.Color(235, 235, 235));
        btnFine.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnFine.setText("Fine");
        btnFine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFineActionPerformed(evt);
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
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOptionsLayout.createSequentialGroup()
                        .addGroup(panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnFine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(btnPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panOptionsLayout.setVerticalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOptionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFine)
                    .addComponent(btnPay))
                .addGap(18, 18, 18)
                .addComponent(btnQuit)
                .addContainerGap())
        );

        panData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblIdStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblIdStudent.setText("ID Student:");

        txtIdStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblDescription.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblDescription.setText("Description:");

        cmbDescription.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbDescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Return Delay", "Damaged Book", "Loss of the Book" }));

        lblValue.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblValue.setText("Value:");

        try {
            txtValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtValue.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        jLabel1.setText("====================================================");

        lblStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblStudent.setText("Student:");

        txtStudent.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblTotal.setText("Total Payable:");

        txtTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout panDataLayout = new javax.swing.GroupLayout(panData);
        panData.setLayout(panDataLayout);
        panDataLayout.setHorizontalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdStudent)
                            .addComponent(lblDescription)
                            .addComponent(lblValue)
                            .addComponent(lblTotal)
                            .addComponent(lblStudent))
                        .addGap(108, 108, 108)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStudent)
                            .addComponent(txtTotal)
                            .addComponent(cmbDescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdStudent)
                            .addComponent(txtValue)))
                    .addComponent(jLabel1))
                .addGap(12, 12, 12))
        );
        panDataLayout.setVerticalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdStudent)
                    .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(cmbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudent)
                    .addComponent(txtStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        controller.showList();
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        controller.delete();
    }
    
    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {
        controller.pay();
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        this.cleanFields();
        this.enableFields();
        btnDelete.setEnabled(false);
        btnPay.setEnabled(false);
        btnFine.setEnabled(true);
    }
    
    private void btnFineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFineActionPerformed
        controller.add();
    }//GEN-LAST:event_btnFineActionPerformed

    private void tblSearchStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchStudentMouseClicked
        controller.fillInData();
        if (txtTotal.getText().equals("0.0")) {
            btnPay.setEnabled(false);
        } else {
            btnPay.setEnabled(true);
        }
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_tblSearchStudentMouseClicked

    private void tblFinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFinesMouseClicked
        btnDelete.setEnabled(true);
        btnPay.setEnabled(false);
        btnFine.setEnabled(false);
    }//GEN-LAST:event_tblFinesMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
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
            java.util.logging.Logger.getLogger(FineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            new FineView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFine;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbDescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblIdStudent;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudentSearch;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValue;
    private javax.swing.JPanel panData;
    private javax.swing.JPanel panOptions;
    private javax.swing.JPanel panSearch;
    private javax.swing.JTable tblFines;
    private javax.swing.JTable tblSearchStudent;
    private javax.swing.JTextField txtIdStudent;
    private javax.swing.JTextField txtStudent;
    private javax.swing.JTextField txtStudentSearch;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JFormattedTextField txtValue;
    // End of variables declaration//GEN-END:variables
}