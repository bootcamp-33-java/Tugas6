/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import icontrollers.ICountryController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Country;
import tools.DBConnection;

/**
 *
 * @author Galih Satriya
 */
public class JICountryView extends javax.swing.JInternalFrame {

    DBConnection connection = new DBConnection();
    ICountryController icc = new CountryController(connection.getConnection());
    private DefaultTableModel model;

    public JICountryView() {
        initComponents();
        model = new DefaultTableModel();
        TableCountry.setModel(model);
        model.addColumn("No.");
        model.addColumn("CountryId");
        model.addColumn("Name");
        model.addColumn("RegionId");
        showTableCountry();
    }

    public void resetTextCountry() {
        TextCidCountry.setText("");
        TextNameCountry.setText("");
        TextRidCountry.setText("");
        TextCidCountry.setEditable(true);
        btnInsertCountry.setEnabled(true);
    }

    public void showTableCountry() {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        Object[] row = new Object[4];
        List<Country> country = new ArrayList<>();
        country = icc.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = i + 1;
            row[1] = country.get(i).getCid();
            row[2] = country.get(i).getName();
            row[3] = country.get(i).getRid();

            model.addRow(row);
        }
    }

    public void showTableCountry(String s) {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        Object[] row = new Object[4];
        List<Country> country = new ArrayList<>();
        country = icc.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = i + 1;
            row[1] = country.get(i).getCid();
            row[2] = country.get(i).getName();
            row[3] = country.get(i).getRid();
            model.addRow(row);
        }
    }

    public void updateTableCountry() {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        model.setRowCount(0);
        showTableCountry();
    }

    public void updateTableCountry(String s) {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        model.setRowCount(0);
        if (s == "") {
            showTableCountry();
        }
        showTableCountry(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableCountry = new javax.swing.JTable();
        TextRidCountry = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnInsertCountry = new javax.swing.JButton();
        btnDeleteCountry = new javax.swing.JButton();
        btnUpdateCountry = new javax.swing.JButton();
        TextNameCountry = new javax.swing.JTextField();
        TextCidCountry = new javax.swing.JTextField();
        TxtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        TableCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "Name", "R.Id"
            }
        ));
        TableCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCountryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCountry);

        TextRidCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextRidCountryActionPerformed(evt);
            }
        });

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

        TextNameCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNameCountryActionPerformed(evt);
            }
        });

        TextCidCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCidCountryActionPerformed(evt);
            }
        });

        TxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("Country Id");

        jLabel3.setText("Name");

        jLabel4.setText("Region Id");

        jLabel1.setText("COUNTRY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnInsertCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateCountry)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteCountry))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextCidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextNameCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextRidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNameCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextRidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCountry)
                    .addComponent(btnUpdateCountry)
                    .addComponent(btnInsertCountry))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextRidCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextRidCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextRidCountryActionPerformed

    private void TextNameCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNameCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNameCountryActionPerformed

    private void TextCidCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCidCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCidCountryActionPerformed

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        model.setRowCount(0);
        List<Country> act2 = icc.search(TxtSearch.getText());
        Object[] row = new Object[4];
        List<Country> country = new ArrayList<>();
        country = icc.search(TxtSearch.getText());
        int count = 0;

        for (Country c : icc.search(TxtSearch.getText())) {
            row[0] = count + 1;
            row[1] = country.get(count).getCid();
            row[2] = country.get(count).getName();
            row[3] = country.get(count).getRid();
            model.addRow(row);
            count = count + 1;
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInsertCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dimasukkan", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.insert(TextCidCountry.getText(), TextNameCountry.getText(), TextRidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnInsertCountryActionPerformed

    private void btnUpdateCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan diperbarui", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.update(TextCidCountry.getText(), TextNameCountry.getText(), TextRidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateCountryActionPerformed

    private void btnDeleteCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.delete(TextCidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteCountryActionPerformed

    private void TableCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCountryMouseClicked
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        int SelectRowIndex = TableCountry.getSelectedRow();

        TextCidCountry.setEditable(false);
        btnInsertCountry.setEnabled(true);
        TextCidCountry.setText(model.getValueAt(SelectRowIndex, 0).toString());
        TextNameCountry.setText(model.getValueAt(SelectRowIndex, 1).toString());
        TextRidCountry.setText(model.getValueAt(SelectRowIndex, 2).toString());
// TODO add your handling code here:
    }//GEN-LAST:event_TableCountryMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCountry;
    private javax.swing.JTextField TextCidCountry;
    private javax.swing.JTextField TextNameCountry;
    private javax.swing.JTextField TextRidCountry;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JButton btnDeleteCountry;
    private javax.swing.JButton btnInsertCountry;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
