/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminWorkArea.Professors;

import AdminWorkArea.ManageProfessorJPanel;
import AdminWorkArea.Students.*;
import Database.DatabaseConnection;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ui.LandingJPanel;
import ui.MainJFrame;

/**
 *
 * @author Vaishnavi Choukwale
 */
public class AdminViewProfessorJPanel extends javax.swing.JPanel {
    private MainJFrame mainframe;
     private String selectedNUID;
     private String selectedCourse;
     private String coursename;
    /**
     * Creates new form AdminViewStudentJPanel
     */
    public AdminViewProfessorJPanel(MainJFrame mainframe, String selectedNUID) {
        initComponents();
        
        this.mainframe = mainframe;
        this.selectedNUID = selectedNUID;
        populateProfessorTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
      private void populateProfessorTable() {
    DefaultTableModel model = (DefaultTableModel) tblProfessor.getModel();
    model.setRowCount(0); // Clear the table

    try {
        Connection connection = (Connection)DatabaseConnection.getConnection();

        // Define the SQL query to retrieve professor data
        String sql = "SELECT courseid,nuid, professor, coursename, year, semester, my_rating, course_rating FROM courses WHERE nuid = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(selectedNUID));
        
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
           
            txtProfessorName.setText(resultSet.getString("professor"));
            String my_rating = resultSet.getString("my_rating");
            if(my_rating == null){
                txtRating.setText("Not Available");
                
            }
            else{
                txtRating.setText(resultSet.getString("my_rating"));
            }
             row.add(resultSet.getString("courseid"));
            row.add(resultSet.getString("coursename"));
            row.add(resultSet.getString("year"));
            row.add(resultSet.getString("semester"));
           selectedNUID = resultSet.getString("nuid");
//           selectedCourse = resultSet.getString("courseid");
            
            String course_rating = resultSet.getString("course_rating");
            System.out.println(course_rating + "course_rating");
            if(course_rating == null || course_rating.isEmpty()){
                System.out.println("NA");
                row.add("Not Available");
            }
            else{
                row.add(course_rating);
               
            }
            model.addRow(row);
            model.fireTableDataChanged(); 
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

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtProfessorName = new javax.swing.JTextField();
        txtRating = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnFeedback = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back (1).png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jScrollPane3.setPreferredSize(new java.awt.Dimension(500, 500));

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CourseID", "Course", "Year", "Semester", "Course Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProfessor);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 34)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Professor Course Details");

        txtProfessorName.setEditable(false);
        txtProfessorName.setBackground(new java.awt.Color(0, 0, 0));
        txtProfessorName.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        txtProfessorName.setForeground(new java.awt.Color(255, 255, 255));
        txtProfessorName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProfessorName.setBorder(null);

        txtRating.setEditable(false);
        txtRating.setBackground(new java.awt.Color(0, 0, 0));
        txtRating.setForeground(new java.awt.Color(255, 255, 255));
        txtRating.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRating.setBorder(null);
        txtRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRatingActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Variable", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("Rating");

        btnFeedback.setForeground(new java.awt.Color(0, 102, 102));
        btnFeedback.setText("Give Feedback");
        btnFeedback.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFeedback.setBorderPainted(false);
        btnFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtRating, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(150, 150, 150)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtProfessorName, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(txtProfessorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDelete, btnFeedback});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        ManageProfessorJPanel manageprof = new ManageProfessorJPanel(mainframe);
        mainframe.setRightComponent(manageprof);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProfessor.getSelectedRow();
        if (selectedRow != -1) {
            // Get the NUID value from the first column of the selected row
//            selectedNUID = (String) tblProfessor.getValueAt(selectedRow, 0);

            // Now you have the NUID value
            System.out.println("Selected NUID: " + selectedNUID);
//            deleteProfessor(selectedNUID);

        } else {
            // Handle the case where no row is selected
            System.out.println("No row selected.");
            JOptionPane.showMessageDialog(this, "No row selected.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRatingActionPerformed

    private void btnFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProfessor.getSelectedRow();
        if (selectedRow != -1) {
            // Get the NUID value from the first column of the selected row
            selectedCourse = (String) tblProfessor.getValueAt(selectedRow, 0);
            coursename =(String) tblProfessor.getValueAt(selectedRow, 1);

            // Now you have the NUID value
            System.out.println("Selected NUID: " + selectedNUID);
            System.out.println("Selected NUID: " + selectedCourse);
            GiveProfessorFeedbackJPanel givefeedback = new GiveProfessorFeedbackJPanel(mainframe,selectedNUID,selectedCourse,coursename);
            mainframe.setRightComponent(givefeedback);
        } else {
            // Handle the case where no row is selected
            System.out.println("No row selected.");
            JOptionPane.showMessageDialog(this, "No row selected.");
        }
    }//GEN-LAST:event_btnFeedbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTextField txtProfessorName;
    private javax.swing.JTextField txtRating;
    // End of variables declaration//GEN-END:variables
}