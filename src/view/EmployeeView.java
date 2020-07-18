package view;

import controller.EmployeeController;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author luan
 */
public class EmployeeView extends javax.swing.JFrame {
    
    private EmployeeController controller;
    
    public EmployeeView() {
        this.initComponents();
        this.disableFields();
        controller = new EmployeeController(this);
        controller.showList();
    }
    
    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }
    
    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }
    
    public JFormattedTextField getTxtCPF() {
        return txtCPF;
    }

    public void setTxtCPF(JFormattedTextField txtCPF) {
        this.txtCPF = txtCPF;
    }
    
    public JComboBox<String> getCmbSex() {
        return cmbSex;
    }

    public void setCmbSex(JComboBox<String> cmbSex) {
        this.cmbSex = cmbSex;
    }
    
    public JFormattedTextField getTxtBirthday() {
        return txtBirthday;
    }

    public void setTxtBirthday(JFormattedTextField txtBirthday) {
        this.txtBirthday = txtBirthday;
    }
    
    public JFormattedTextField getTxtTelephone() {
        return txtTelephone;
    }

    public void setTxtTelephone(JFormattedTextField txtTelephone) {
        this.txtTelephone = txtTelephone;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(JTextField txtAddress) {
        this.txtAddress = txtAddress;
    }
    
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }
    
    public JPasswordField getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(JPasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }
    
    public JPasswordField getPwdConfirmPassword() {
        return pwdConfirmPassword;
    }

    public void setPwdConfirmPassword(JPasswordField pwdConfirmPassword) {
        this.pwdConfirmPassword = pwdConfirmPassword;
    }
    
    public JTextField getTxtNameSearch() {
        return txtNameSearch;
    }

    public void setTxtNameSearch(JTextField txtNameSearch) {
        this.txtNameSearch = txtNameSearch;
    }
    
    public JTable getTblSearch() {
        return tblSearch;
    }

    public void setTblSearch(JTable tblSearch) {
        this.tblSearch = tblSearch;
    }
    
    public void enableFields() {
        txtName.setEditable(true);
        txtCPF.setEditable(true);
        cmbSex.setEnabled(true);
        txtBirthday.setEditable(true);
        txtTelephone.setEditable(true);
        txtAddress.setEditable(true);
        txtUsername.setEditable(true);
        pwdPassword.setEditable(true);
        pwdConfirmPassword.setEditable(true);
    }
    
    public void disableFields() {
        txtId.setEditable(false);
        txtName.setEditable(false);
        txtCPF.setEditable(false);
        cmbSex.setEnabled(false);
        txtBirthday.setEditable(false);
        txtTelephone.setEditable(false);
        txtAddress.setEditable(false);
        txtUsername.setEditable(false);
        pwdPassword.setEditable(false);
        pwdConfirmPassword.setEditable(false);
        
        btnDelete.setEnabled(false);
        btnAlter.setEnabled(false);
        btnRegister.setEnabled(false);
    }
    
    public void cleanFields() {
        txtId.setText("");
        txtName.setText("");
        txtCPF.setText("");
        cmbSex.getSelectedIndex();
        txtBirthday.setText("");
        txtTelephone.setText("");
        txtAddress.setText("");
        txtUsername.setText("");
        pwdPassword.setText("");
        pwdConfirmPassword.setText("");
    }
    
    public void fillsFields(int id, String name, String cpf, String sex, String birthday, String telephone, String address, String username) {
        txtId.setText(id+"");
        txtName.setText(name);
        txtCPF.setText(cpf);
        cmbSex.setSelectedItem(sex);
        txtBirthday.setText(birthday);
        txtTelephone.setText(telephone);
        txtAddress.setText(address);
        txtUsername.setText(username);
    }
    
    public boolean checksData() {
        return !txtName.getText().equals("") && !txtCPF.getText().equals("")  && !cmbSex.getSelectedItem().equals("")
                && !txtBirthday.getText().equals("") && !txtAddress.getText().equals("") && !txtUsername.getText().equals("")
                && !Arrays.toString(pwdPassword.getPassword()).equals("") && !Arrays.toString(pwdConfirmPassword.getPassword()).equals("");
    }
    
    public boolean checkPasswords() {
        return !pwdPassword.getText().equals("") && pwdPassword.getText().equals(pwdConfirmPassword.getText());
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
        lblNameSearch = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();
        panOptions = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnAlter = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        panData = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblSex = new javax.swing.JLabel();
        cmbSex = new javax.swing.JComboBox<>();
        lblBirthday = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JFormattedTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JFormattedTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        lblConfirmPassword = new javax.swing.JLabel();
        pwdConfirmPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee");
        setPreferredSize(new java.awt.Dimension(802, 670));
        setResizable(false);

        panSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblNameSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblNameSearch.setText("Name:");

        txtNameSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        btnSearch.setBackground(new java.awt.Color(235, 235, 235));
        btnSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tblSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "CPF", "Sex", "Birthday", "Telephone", "Address", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSearchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSearch);

        javax.swing.GroupLayout panSearchLayout = new javax.swing.GroupLayout(panSearch);
        panSearch.setLayout(panSearchLayout);
        panSearchLayout.setHorizontalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panSearchLayout.createSequentialGroup()
                        .addComponent(lblNameSearch)
                        .addGap(113, 113, 113)
                        .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panSearchLayout.setVerticalGroup(
            panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSearchLayout.createSequentialGroup()
                .addGroup(panSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
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

        btnAlter.setBackground(new java.awt.Color(235, 235, 235));
        btnAlter.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnAlter.setText("Alter");
        btnAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterActionPerformed(evt);
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

        btnRegister.setBackground(new java.awt.Color(235, 235, 235));
        btnRegister.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
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
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnAlter, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panOptionsLayout.setVerticalGroup(
            panOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panOptionsLayout.createSequentialGroup()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuit)
                .addContainerGap())
        );

        panData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        lblId.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblId.setText("ID:");

        txtId.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblName.setText("Name:");

        txtName.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblCPF.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblCPF.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblSex.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblSex.setText("Sex:");

        cmbSex.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cmbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Feminine" }));

        lblBirthday.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblBirthday.setText("Birthday:");

        try {
            txtBirthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBirthday.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBirthday.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblAddress.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblAddress.setText("Address:");

        txtAddress.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblTelephone.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblTelephone.setText("Telephone:");

        try {
            txtTelephone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelephone.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblUsername.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblPassword.setText("Password:");

        pwdPassword.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        lblConfirmPassword.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblConfirmPassword.setText("Confirm Password:");

        pwdConfirmPassword.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N

        javax.swing.GroupLayout panDataLayout = new javax.swing.GroupLayout(panData);
        panData.setLayout(panDataLayout);
        panDataLayout.setHorizontalGroup(
            panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPassword)
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPF)
                            .addComponent(lblName)
                            .addComponent(lblBirthday)
                            .addComponent(lblUsername)))
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblConfirmPassword))
                    .addComponent(lblId)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress)
                    .addGroup(panDataLayout.createSequentialGroup()
                        .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pwdPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDataLayout.createSequentialGroup()
                                    .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTelephone)
                                        .addComponent(lblSex))
                                    .addGap(18, 18, 18)
                                    .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTelephone)
                                        .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSex)
                    .addComponent(cmbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBirthday)
                    .addComponent(lblTelephone)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword)
                    .addComponent(pwdConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        controller.showList();
    }

    private void tblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSearchMouseClicked
        controller.fillInData();
        btnDelete.setEnabled(true);
        btnAlter.setEnabled(true);
        btnRegister.setEnabled(false);
    }//GEN-LAST:event_tblSearchMouseClicked
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        controller.delete();
    }
    
    private void btnAlterActionPerformed(java.awt.event.ActionEvent evt) {
        controller.alter();
    }

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        this.cleanFields();
        this.enableFields();
        btnDelete.setEnabled(false);
        btnAlter.setEnabled(false);
        btnRegister.setEnabled(true);
    }
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        controller.add();
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EmployeeView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlter;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameSearch;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panData;
    private javax.swing.JPanel panOptions;
    private javax.swing.JPanel panSearch;
    private javax.swing.JPasswordField pwdConfirmPassword;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JFormattedTextField txtBirthday;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JFormattedTextField txtTelephone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
