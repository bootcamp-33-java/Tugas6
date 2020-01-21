/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import controllers.RegionController;
import icontrollers.ICountryController;
import icontrollers.IRegionController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Country;
import models.Region;
import tools.DBConnection;

/**
 *
 * @author Galih Satriya
 */
public class JICountryView extends javax.swing.JInternalFrame {
    
    DBConnection connection = new DBConnection();
    ICountryController icc = new CountryController(connection.getConnection());
    IRegionController irc = new RegionController(connection.getConnection());
    private DefaultTableModel model;
    
    public JICountryView() {
        initComponents();
        model = (DefaultTableModel) tblCountry.getModel();
        refresh();
        
        cbRId.addItem("Choose Region Id");
        for (Region r : irc.getAll()) {
            cbRId.addItem(String.valueOf(r.getId()));
        }
   
//        model = new DefaultTableModel();
//        TableCountry.setModel(model);
//        model.addColumn("No.");
//        model.addColumn("CountryId");
//        model.addColumn("Name");
//        model.addColumn("RegionId");
//        showTableCountry();
    }

    public void refresh() {
        model.setRowCount(0);
        Object[] row = new Object[4];
        List<Country> country = icc.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = i + 1;
            row[1] = country.get(i).getid();
            row[2] = country.get(i).getName();
            row[3] = country.get(i).getRid();
            model.addRow(row);
        }
        
        
    }

//    public void resetTextCountry() {
//        TextCidCountry.setText("");
//        TextNameCountry.setText("");
//        TextRidCountry.setText("");
//        TextCidCountry.setEditable(true);
//        btnInsertCountry.setEnabled(true);
//    }
//    public void showTableCountry() {
//        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
//        Object[] row = new Object[4];
//        List<Country> country = new ArrayList<>();
//        country = icc.getAll();
//        for (int i = 0; i < country.size(); i++) {
//            row[0] = i + 1;
//            row[1] = country.get(i).getCid();
//            row[2] = country.get(i).getName();
//            row[3] = country.get(i).getRid();
//
//            model.addRow(row);
//        }
//    }
//    public void showTableCountry(String s) {
//        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
//        Object[] row = new Object[4];
//        List<Country> country = new ArrayList<>();
//        country = icc.getAll();
//        for (int i = 0; i < country.size(); i++) {
//            row[0] = i + 1;
//            row[1] = country.get(i).getCid();
//            row[2] = country.get(i).getName();
//            row[3] = country.get(i).getRid();
//            model.addRow(row);
//        }
//    }
//
//    public void updateTableCountry() {
//        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
//        model.setRowCount(0);
//        showTableCountry();
//    }
//
//    public void updateTableCountry(String s) {
//        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
//        model.setRowCount(0);
//        if (s == "") {
//            showTableCountry();
//        }
//        showTableCountry(s);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnInsertCountry = new javax.swing.JButton();
        btnDeleteCountry = new javax.swing.JButton();
        btnUpdateCountry = new javax.swing.JButton();
        txtNameCountry = new javax.swing.JTextField();
        txtCidCountry = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbRId = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();

        tblCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "Name", "R.Id"
            }
        ));
        tblCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCountryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCountry);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnInsertCountry.setText("Insert");
        btnInsertCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCountryActionPerformed(evt);
            }
        });

        btnDeleteCountry.setText("Delete");
        btnDeleteCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCountryActionPerformed(evt);
            }
        });

        btnUpdateCountry.setText("Update");
        btnUpdateCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCountryActionPerformed(evt);
            }
        });

        txtNameCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameCountryActionPerformed(evt);
            }
        });

        txtCidCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidCountryActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("Country Id");

        jLabel3.setText("Name");

        jLabel4.setText("Region Id");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("COUNTRY");

        cbRId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRIdActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh Table");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbRId, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNameCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnInsertCountry)
                                                .addGap(14, 14, 14)
                                                .addComponent(btnUpdateCountry)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnDeleteCountry))
                                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch)
                                        .addGap(4, 4, 4)))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCountry)
                    .addComponent(btnUpdateCountry)
                    .addComponent(btnInsertCountry))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameCountryActionPerformed

    private void txtCidCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidCountryActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        model.setRowCount(0);
        List<Country> act2 = icc.search(txtSearch.getText());
        Object[] row = new Object[4];
        List<Country> country = new ArrayList<>();
        country = icc.search(txtSearch.getText());
        int count = 0;
        
        for (Country c : icc.search(txtSearch.getText())) {
            row[0] = count + 1;
            row[1] = country.get(count).getid();
            row[2] = country.get(count).getName();
            row[3] = country.get(count).getRid();
            model.addRow(row);
            count = count + 1;
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInsertCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCountryActionPerformed
//        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dimasukkan", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (confirm == JOptionPane.YES_NO_OPTION) {
        JOptionPane.showMessageDialog(null, icc.insert(txtCidCountry.getText(), txtNameCountry.getText(), cbRId.getSelectedItem().toString()));
//            updateTableCountry();
//            resetTextCountry();

// TODO add your handling code here:
    }//GEN-LAST:event_btnInsertCountryActionPerformed

    private void btnUpdateCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCountryActionPerformed
//        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan diperbarui", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (confirm == JOptionPane.YES_NO_OPTION) {
        JOptionPane.showMessageDialog(null, icc.update(txtCidCountry.getText(), txtNameCountry.getText(), cbRId.getSelectedItem().toString()));
        refresh();
//            updateTableCountry();
//            resetTextCountry();

// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateCountryActionPerformed

    private void btnDeleteCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCountryActionPerformed
//        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if (confirm == JOptionPane.YES_NO_OPTION) {
        JOptionPane.showMessageDialog(null, icc.delete(txtCidCountry.getText()));
        refresh();
//        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteCountryActionPerformed

    private void tblCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCountryMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblCountry.getModel();
        int SelectRowIndex = tblCountry.getSelectedRow();
        
        txtCidCountry.setEditable(false);
        btnInsertCountry.setEnabled(true);
        txtCidCountry.setText(model.getValueAt(SelectRowIndex, 1).toString());
        txtNameCountry.setText(model.getValueAt(SelectRowIndex, 2).toString());
        cbRId.setSelectedItem(model.getValueAt(SelectRowIndex, 3).toString());
// TODO add your handling code here:
    }//GEN-LAST:event_tblCountryMouseClicked

    private void cbRIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRIdActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCountry;
    private javax.swing.JButton btnInsertCountry;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateCountry;
    private javax.swing.JComboBox<String> cbRId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCountry;
    private javax.swing.JTextField txtCidCountry;
    private javax.swing.JTextField txtNameCountry;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}