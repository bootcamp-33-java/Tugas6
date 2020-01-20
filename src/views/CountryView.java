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
 * @author FIKRI-PC
 */
public class CountryView extends javax.swing.JFrame {

    DBConnection connection = new DBConnection();
    ICountryController icc = new CountryController(connection.getConnection());
    private DefaultTableModel model;

    public CountryView() {
        initComponents();
        model = new DefaultTableModel();
        TableCountry.setModel(model);
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
        BtnInsertCountry.setEnabled(true);
    }

    public void showTableCountry() {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        Object[] row = new Object[3];
        List<Country> country = new ArrayList<>();
        country = icc.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = country.get(i).getCid();
            row[1] = country.get(i).getName();
            row[2] = country.get(i).getRid();
            model.addRow(row);
        }
    }

    public void showTableCountry(String s) {
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        Object[] row = new Object[3];
        List<Country> country = new ArrayList<>();
        country = icc.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = country.get(i).getCid();
            row[1] = country.get(i).getName();
            row[2] = country.get(i).getRid();
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextCidCountry = new javax.swing.JTextField();
        TextNameCountry = new javax.swing.JTextField();
        BtnInsertCountry = new javax.swing.JButton();
        BtnUpdateCountry = new javax.swing.JButton();
        BtnDeleteCountry = new javax.swing.JButton();
        TextSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCountry = new javax.swing.JTable();
        TextRidCountry = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ComboSearch = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("Insert New Region");

        jLabel2.setText("Cid");

        jLabel3.setText("Name");

        TextCidCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCidCountryActionPerformed(evt);
            }
        });

        BtnInsertCountry.setText("Insert");
        BtnInsertCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertCountryActionPerformed(evt);
            }
        });

        BtnUpdateCountry.setText("Update");
        BtnUpdateCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateCountryActionPerformed(evt);
            }
        });

        BtnDeleteCountry.setText("Delete");
        BtnDeleteCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteCountryActionPerformed(evt);
            }
        });

        TextSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSearchActionPerformed(evt);
            }
        });
        TextSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextSearchKeyReleased(evt);
            }
        });

        TableCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cid", "Name", "Rid"
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

        jLabel4.setText("Rid");

        ComboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Name" }));
        ComboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TextSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(BtnInsertCountry)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnUpdateCountry)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnDeleteCountry)
                                    .addComponent(ComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(TextCidCountry))))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextRidCountry)
                                    .addComponent(TextNameCountry))))
                        .addContainerGap())))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNameCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextRidCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInsertCountry)
                    .addComponent(BtnUpdateCountry)
                    .addComponent(BtnDeleteCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(492, 492, 492))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void TextCidCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCidCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCidCountryActionPerformed
    private void BtnInsertCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dimasukkan", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.insert(TextCidCountry.getText(), TextNameCountry.getText(), TextRidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }
    }//GEN-LAST:event_BtnInsertCountryActionPerformed
    private void TextSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSearchActionPerformed
        
    }//GEN-LAST:event_TextSearchActionPerformed
    private void BtnUpdateCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan diperbarui", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.update(TextCidCountry.getText(), TextNameCountry.getText(), TextRidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }   // TODO add your handling code here:
    }//GEN-LAST:event_BtnUpdateCountryActionPerformed

    private void BtnDeleteCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteCountryActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, icc.delete(TextCidCountry.getText()));
            updateTableCountry();
            resetTextCountry();
        }// TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteCountryActionPerformed

    private void TableCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCountryMouseClicked
        DefaultTableModel model = (DefaultTableModel) TableCountry.getModel();
        int SelectRowIndex = TableCountry.getSelectedRow();

        TextCidCountry.setEditable(false);
        BtnInsertCountry.setEnabled(true);
        TextCidCountry.setText(model.getValueAt(SelectRowIndex, 0).toString());
        TextNameCountry.setText(model.getValueAt(SelectRowIndex, 1).toString());
        TextRidCountry.setText(model.getValueAt(SelectRowIndex, 2).toString());
// TODO add your handling code here:
    }//GEN-LAST:event_TableCountryMouseClicked

    private void TextRidCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextRidCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextRidCountryActionPerformed

    private void ComboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboSearchActionPerformed

    private void TextSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextSearchKeyReleased
        String filter = (String) ComboSearch.getSelectedItem();
        String val = TextSearch.getText();
        switch (filter) {
            case "Id":
                if (val.isEmpty()) {
                    showTableCountry();
                } else {
                    showTableCountry();
                    model.getDataVector().removeAllElements();
                    for (Country c : icc.getById(val)) {
                        Object[] row = new Object[2];
                        row[0] = c.getCid();
                        model.addRow(row);
                    }
                }
                break;
            case "Name":
                try {
                    if (val.isEmpty()) {
                        showTableCountry();
                    } else {
                        showTableCountry();
                        model.getDataVector().removeAllElements();
                        for (Country c : icc.getByName(val)) {
                            Object[] row = new Object[2];
                            row[1] = c.getName();
                            model.addRow(row);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }// TODO add your handling code here:
    }//GEN-LAST:event_TextSearchKeyReleased

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
            java.util.logging.Logger.getLogger(CountryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CountryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CountryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CountryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CountryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeleteCountry;
    private javax.swing.JButton BtnInsertCountry;
    private javax.swing.JButton BtnUpdateCountry;
    private javax.swing.JComboBox<String> ComboSearch;
    private javax.swing.JTable TableCountry;
    private javax.swing.JTextField TextCidCountry;
    private javax.swing.JTextField TextNameCountry;
    private javax.swing.JTextField TextRidCountry;
    private javax.swing.JTextField TextSearch;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}