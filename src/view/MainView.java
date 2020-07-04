package view;

/**
 *
 * @author luan
 */
public class MainView extends javax.swing.JFrame {

    private EmployeeView manageEmployee;
    private StudentView manageStudent;
    private BookView manageBook;
            
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnbMenuBar = new javax.swing.JMenuBar();
        mnuManage = new javax.swing.JMenu();
        mniEmpoyee = new javax.swing.JMenuItem();
        mniStudent = new javax.swing.JMenuItem();
        mniBook = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnbMenuBar.setBorder(null);
        mnbMenuBar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        mnuManage.setText("Manage");
        mnuManage.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N

        mniEmpoyee.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        mniEmpoyee.setText("Employee");
        mniEmpoyee.setBorder(null);
        mniEmpoyee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEmpoyeeActionPerformed(evt);
            }
        });
        mnuManage.add(mniEmpoyee);

        mniStudent.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        mniStudent.setText("Student");
        mniStudent.setBorder(null);
        mniStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniStudentActionPerformed(evt);
            }
        });
        mnuManage.add(mniStudent);

        mniBook.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        mniBook.setText("Book");
        mniBook.setBorder(null);
        mniBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBookActionPerformed(evt);
            }
        });
        mnuManage.add(mniBook);

        mnbMenuBar.add(mnuManage);

        setJMenuBar(mnbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniEmpoyeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmpoyeeActionPerformed
        manageEmployee = new EmployeeView();
        manageEmployee.setVisible(true);
    }//GEN-LAST:event_mniEmpoyeeActionPerformed

    private void mniStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniStudentActionPerformed
        manageStudent = new StudentView();
        manageStudent.setVisible(true);
    }//GEN-LAST:event_mniStudentActionPerformed

    private void mniBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBookActionPerformed
        manageBook = new BookView();
        manageBook.setVisible(true);
    }//GEN-LAST:event_mniBookActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar mnbMenuBar;
    private javax.swing.JMenuItem mniBook;
    private javax.swing.JMenuItem mniEmpoyee;
    private javax.swing.JMenuItem mniStudent;
    private javax.swing.JMenu mnuManage;
    // End of variables declaration//GEN-END:variables
}
