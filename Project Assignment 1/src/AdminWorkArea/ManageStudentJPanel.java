/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminWorkArea;

import AdminWorkArea.Professors.AdminViewProfessorJPanel;
import AdminWorkArea.Students.AdminCreateStudentJPanel;
import AdminWorkArea.Students.AdminUpdateStudentJPanel;
import AdminWorkArea.Students.AdminViewStudentJPanel;
import Database.DatabaseConnection;
import adminMenus.AdminWorkAreaMenu;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.MainJFrame;

/**
 *
 * @author abhilashkumargorle
 */
public class ManageStudentJPanel extends javax.swing.JPanel {
    
     private MainJFrame mainframe;
     private String selectedNUID;

    /**
     * Creates new form AdminJPanel
     */
    public ManageStudentJPanel(MainJFrame mainframe) {
        this.mainframe = mainframe;
        initComponents();
        populateStudentTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void deleteProfessor(String NUID) {
       
        try {
            Connection connection = (Connection)DatabaseConnection.getConnection();

            String sql = "DELETE FROM users WHERE nuid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, NUID);

            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
//            DatabaseConnection.closeConnection(connection);
            populateStudentTable();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting course.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateStudentTable() {
    DefaultTableModel model = (DefaultTableModel) tblStudent.getModel();
    model.setRowCount(0); // Clear the table

    try {
        Connection connection = (Connection)DatabaseConnection.getConnection();

        // Define the SQL query to retrieve professor data
        String sql = "SELECT u.nuid, u.name, u.contact_number, u.email, u.address, s.graduation_status, s.gpa " +
             "FROM users u " +
             "LEFT JOIN student2 s ON u.nuid = s.nuid " +
             "WHERE u.profile_type = 'Student'";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            row.add(resultSet.getString("nuid"));
            row.add(resultSet.getString("name"));
            row.add(resultSet.getString("contact_number"));
            row.add(resultSet.getString("email"));
            row.add(resultSet.getString("address"));
            row.add(resultSet.getString("graduation_status")); // Add graduation_status
            row.add(resultSet.getString("gpa")); // Add overall_rank
            model.addRow(row);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
//        DatabaseConnection.closeConnection();
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btnCreateProfile = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(969, 407));

        jScrollPane3.setBorder(null);
        jScrollPane3.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        jScrollPane3.setPreferredSize(new java.awt.Dimension(500, 500));

        tblStudent.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NUID", "Name", "Contact Number", "Email", "Address", "Graduation Status", "GPA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudent.setGridColor(new java.awt.Color(255, 255, 255));
        tblStudent.setRowHeight(21);
        tblStudent.setRowMargin(2);
        jScrollPane3.setViewportView(tblStudent);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Search NUID..");
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnsearch.setForeground(new java.awt.Color(0, 102, 102));
        btnsearch.setText("Search");
        btnsearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsearch.setBorderPainted(false);
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnCreateProfile.setForeground(new java.awt.Color(0, 102, 102));
        btnCreateProfile.setText("Create Profile");
        btnCreateProfile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateProfile.setBorderPainted(false);
        btnCreateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProfileActionPerformed(evt);
            }
        });

        btnView.setForeground(new java.awt.Color(0, 102, 102));
        btnView.setText("View");
        btnView.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnView.setBorderPainted(false);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(255, 102, 51));
        btnback.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back (1).png"))); // NOI18N
        btnback.setText("Back");
        btnback.setBorder(null);
        btnback.setContentAreaFilled(false);
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnUpdate1.setForeground(new java.awt.Color(0, 102, 102));
        btnUpdate1.setText("Update");
        btnUpdate1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate1.setBorderPainted(false);
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENTS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 431, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreateProfile, btnDelete, btnView});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(109, 109, 109))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreateProfile, btnDelete, btnView});

    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProfileActionPerformed
        // TODO add your handling code here:
        
        AdminCreateStudentJPanel createstu = new AdminCreateStudentJPanel(mainframe);
       mainframe.setRightComponent(createstu);
       

    }//GEN-LAST:event_btnCreateProfileActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStudent.getSelectedRow();
        if (selectedRow != -1) {
            // Get the NUID value from the first column of the selected row
            selectedNUID = (String) tblStudent.getValueAt(selectedRow, 0);

            try {
                 Connection connection = (Connection)DatabaseConnection.getConnection();
                // Establish your database connection here

                // Delete the user record in the "users" table
                String deleteUserQuery = "DELETE FROM users WHERE nuid = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteUserQuery);
                preparedStatement.setString(1, selectedNUID);
                int rowsDeleted = preparedStatement.executeUpdate();
                preparedStatement.close();

                // Check if any records were deleted
                if (rowsDeleted > 0) {
                    populateStudentTable();
                    System.out.println("User record and related records deleted successfully.");
                } else {
                    System.out.println("No records were deleted. NUID not found.");
                }

                // Close the database connection here

            } catch (SQLException e) {
                e.printStackTrace();
                // Handle any database-related errors
            }
        } else {
            // Handle the case where no row is selected
            System.out.println("No row selected.");
            JOptionPane.showMessageDialog(this, "No row selected.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        
        AdminMainJPanel adminlanding = new AdminMainJPanel(mainframe);
        mainframe.setRightComponent(adminlanding);
        AdminWorkAreaMenu adminmenu = new AdminWorkAreaMenu(mainframe);
        mainframe.setLeftComponent(adminmenu);
       
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblStudent.getSelectedRow();
        if (selectedRow != -1) {
            // Get the NUID value from the first column of the selected row
           selectedNUID = (String) tblStudent.getValueAt(selectedRow, 0);

            // Now you have the NUID value
            System.out.println("Selected NUID: " + selectedNUID);
            AdminUpdateStudentJPanel stuupdate = new AdminUpdateStudentJPanel(mainframe,selectedNUID);
        mainframe.setRightComponent(stuupdate);
            
        } else {
            // Handle the case where no row is selected
            System.out.println("No row selected.");
              JOptionPane.showMessageDialog(this, "No row selected.");
        }
        
        
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
          String searchNUID = txtSearch.getText().trim(); // Get the NUID from the text field

        try {
            Connection connection = (Connection) DatabaseConnection.getConnection();
            Integer Flag=0;
             DefaultTableModel tableModel = (DefaultTableModel) tblStudent.getModel();
            // Define the SQL query to retrieve values based on NUID
            String sql;
            if (searchNUID.isEmpty()) {
                 tableModel.setRowCount(0);
                // If searchNUID is empty, retrieve all records
                 populateStudentTable();
            } else {
                Flag=0;
                 tableModel.setRowCount(0);
                // Otherwise, retrieve records based on the NUID
                sql = "SELECT nuid, name, email, address, contact_number, profile_type, username, password FROM users WHERE nuid = ?";
            

            // Create a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            if (!searchNUID.isEmpty()) {
                preparedStatement.setString(1, searchNUID); // Bind the searchNUID if not empty
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            

            boolean found = false; // Flag to check if any results are found

            while (resultSet.next()) {
                // Populate the table with retrieved data
                String NUID = resultSet.getString("nuid");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String contactNumber = resultSet.getString("contact_number");
                String profileType = resultSet.getString("profile_type");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
               
                // Clear the existing table data
                 if (searchNUID.isEmpty()) {
                    Object[] rowData = {NUID, name, email, address, contactNumber, profileType, username, password};
                    tableModel.addRow(rowData);
                 }
                 else{
                     
                    Object[] rowData = {searchNUID, email, address, contactNumber, profileType, username, password};
                    tableModel.addRow(rowData);
                     
                 }

                found = true; // Records were found
            }

            resultSet.close();
            preparedStatement.close();
//            DatabaseConnection.closeConnection(connection);

            if (!found) {
                 tableModel.setRowCount(0);
                // No results found, display a message
                JOptionPane.showMessageDialog(mainframe, "User not found.", "User Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblStudent.getSelectedRow();
        if (selectedRow != -1) {
            // Get the NUID value from the first column of the selected row
           selectedNUID = (String) tblStudent.getValueAt(selectedRow, 0);

            // Now you have the NUID value
            System.out.println("Selected NUID: " + selectedNUID);
            AdminViewStudentJPanel courselist = new AdminViewStudentJPanel(mainframe,selectedNUID);
            mainframe.setRightComponent(courselist);
        } else {
            // Handle the case where no row is selected
            System.out.println("No row selected.");
              JOptionPane.showMessageDialog(this, "No row selected.");
        }
       
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProfile;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}