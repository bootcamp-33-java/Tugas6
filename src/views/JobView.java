/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import controllers.JobController;
import icontrollers.IJobController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Job;
import tools.DBConnection;

/**
 *
 * @author ASUS
 */
public class JobView extends javax.swing.JInternalFrame {
    DBConnection connection = new DBConnection();
    IJobController ijc = new JobController(connection.getConnection());
    private DefaultTableModel model;
    /** Creates new form JobViewInternal */
    public JobView() {
        initComponents();
        
        model = (DefaultTableModel) tblJob.getModel();

        model.setRowCount(0);
        ShowTableJob();
    }
    
    public void resetTextJob() {
        txtId.setText("");
        txtName.setText("");
        txtMinSalary.setText("");
        txtMaxSalary.setText("");
        txtId.setEditable(true);
        btnInsertJob.setEnabled(true);
    }

    public void ShowTableJob() {
        List<Job> jobs = new ArrayList<>();
        Object[] row = new Object[5];
        jobs = ijc.getAll();
        for (int i = 0; i < jobs.size(); i++) {
            row[0] = i + 1;
            row[1] = jobs.get(i).getId();
            row[2] = jobs.get(i).getName();
            row[3] = jobs.get(i).getMinSalary();
            row[4] = jobs.get(i).getMaxSalary();
            model.addRow(row);
        }

    }

    public void ShowTableJob(String s) {
        model.setRowCount(0);
        List<Job> jobs = new ArrayList<>();
        Object[] row = new Object[5];
        jobs = ijc.getAll();
        for (int i = 0; i < jobs.size(); i++) {
            row[0] = i++;
            row[1] = jobs.get(i).getId();
            row[2] = jobs.get(i).getName();
            row[3] = jobs.get(i).getMinSalary();
            row[4] = jobs.get(i).getMaxSalary();
            model.addRow(row);
        }
    }

    public void updateTableJob() {
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        model.setRowCount(0);
        ShowTableJob();
    }

    public void updateTableJob(String s) {
        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        model.setRowCount(0);
        if (s == "") {
            ShowTableJob();
        }
        ShowTableJob();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMinSalary = new javax.swing.JTextField();
        txtMaxSalary = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        btnInsertJob = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJob = new javax.swing.JTable();
        btnUpdateJob = new javax.swing.JButton();
        btnDeleteJob = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSearchJob = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel3.setText("Min Salary");

        jLabel4.setText("Max Salary");

        txtMaxSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxSalaryActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("Insert New Job");

        btnInsertJob.setText("Insert");
        btnInsertJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertJobActionPerformed(evt);
            }
        });

        tblJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "Job ID", "Job Title", "Min Salary", "Max Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJobMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblJob);

        btnUpdateJob.setText("Update");
        btnUpdateJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateJobActionPerformed(evt);
            }
        });

        btnDeleteJob.setText("Delete");
        btnDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        btnSearchJob.setText("Search");
        btnSearchJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchJobActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaxSalary, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1))
                                    .addGap(20, 20, 20)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtName)
                                        .addComponent(txtId)
                                        .addComponent(txtMinSalary))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnInsertJob)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnUpdateJob))
                                    .addComponent(txtSearch))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchJob)
                                    .addComponent(btnDeleteJob))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMinSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaxSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertJob)
                    .addComponent(btnUpdateJob)
                    .addComponent(btnDeleteJob))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchJob)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertJobActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dimasukkan", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.insert(txtId.getText(), txtName.getText(), txtMinSalary.getText(), txtMaxSalary.getText()));
            //            JOptionPane.showMessageDialog(null, ijc.insert(txtId.getText(), txtMinSala txtMinSalary.getText(), txtMaxSalary.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnInsertJobActionPerformed

    private void tblJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJobMouseClicked
        // TODO add your handling code here:
        int SelectRowIndex = tblJob.getSelectedRow();

        btnInsertJob.setEnabled(true);
        txtId.setText(model.getValueAt(SelectRowIndex, 1).toString());
        txtName.setText(model.getValueAt(SelectRowIndex, 2).toString());
        txtMinSalary.setText(model.getValueAt(SelectRowIndex, 3).toString());
        txtMaxSalary.setText(model.getValueAt(SelectRowIndex, 4).toString());
        txtId.setEditable(false);
    }//GEN-LAST:event_tblJobMouseClicked

    private void btnUpdateJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateJobActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan diperbarui", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.update(txtId.getText(), txtName.getText(), txtMinSalary.getText(), txtMaxSalary.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnUpdateJobActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, ijc.delete(txtId.getText()));
            updateTableJob();
            resetTextJob();
        }
    }//GEN-LAST:event_btnDeleteJobActionPerformed

    private void btnSearchJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchJobActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);

        DefaultTableModel model = (DefaultTableModel) tblJob.getModel();
        List<Job> jobs = ijc.search(txtSearch.getText());
        Object[] row = new Object[5];
        List<Job> jobs1 = new ArrayList<>();
        jobs1 = ijc.search(txtSearch.getText());

        int count = 0;

        for (int i = 0; i< jobs1.size(); i++) {

            row[0] = count + 1;
            row[1] = jobs1.get(count).getId();
            row[2] = jobs1.get(count).getName();
            row[3] = jobs1.get(count).getMinSalary();
            row[4] = jobs1.get(count).getMaxSalary();
            model.addRow(row);
            count = count + 1;
        }
        resetTextJob();
    }//GEN-LAST:event_btnSearchJobActionPerformed

    private void txtMaxSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxSalaryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteJob;
    private javax.swing.JButton btnInsertJob;
    private javax.swing.JButton btnSearchJob;
    private javax.swing.JButton btnUpdateJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tblJob;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaxSalary;
    private javax.swing.JTextField txtMinSalary;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
