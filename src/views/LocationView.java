/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import controllers.LocationController;
import icontrollers.ICountryController;
import icontrollers.ILocationController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import models.Country;
import models.Location;
import tools.DBConnection;


/**
 *
 * @author TUF FX504
 */
public class LocationView extends javax.swing.JInternalFrame {

    
     DBConnection connection = new DBConnection();
    ILocationController ilc = new LocationController(connection.getConnection());
    ICountryController icc = new CountryController(connection.getConnection());
    /**
     * Creates new form LocationView
     */
    public LocationView() {
        initComponents();
        refresh();
        
        cbCountryId.addItem("Select");
        for (Country c : icc.getAll()) {
            cbCountryId.addItem(String.valueOf(c.getid()));
        }
    }
    
    public void refresh(){
    DefaultTableModel model = (DefaultTableModel) tblLocation.getModel();
        
       
        model.setRowCount(0);
        Object[] row = new Object[7];
        List<Location> location = new ArrayList<>();
        location = ilc.getAll();
        for (int i = 0; i < location.size(); i++) {
            row[0] = i+1;
            row[1] = location.get(i).getId();
            row[2] = location.get(i).getAddress();
            row[3] = location.get(i).getPostalCode();
            row[4] = location.get(i).getCity();
            row[5] = location.get(i).getStateProvince();
            row[6] = location.get(i).getCountryId();
            model.addRow(row);
            
            
        }
    }
       public void txtreset(){
           txtLocationId.setText("");
        txtStreetAddress.setText("");
        txtPostalCode.setText("");
        txtCity.setText("");
        txtStateProvince.setText("");
        cbCountryId.setSelectedItem(null);
        
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
        jTable1 = new javax.swing.JTable();
        txtLocationId = new javax.swing.JTextField();
        txtStreetAddress = new javax.swing.JTextField();
        btn_Delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLocation = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        txtInput = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        txtPostalCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGetAll = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGetById = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStateProvince = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbCountryId = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        btn_Delete.setText("Delete");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        tblLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "LocationID", "Street Address", "Postal Code", "City", "State Province", "Country ID"
            }
        ));
        tblLocation.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblLocationAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLocationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLocation);

        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Location ID");

        btnGetAll.setText("Refresh Table");
        btnGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllActionPerformed(evt);
            }
        });

        jLabel2.setText("Street Address");

        btnGetById.setText("Sesuai dengan ID");
        btnGetById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetByIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Postal Code");

        jLabel8.setText("Pencarian Sebagai :");

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        jLabel4.setText("City");

        jLabel9.setText("Input :");

        jLabel5.setText("State Province");

        cbCountryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Location");

        jLabel6.setText("Country ID");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSave)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_Delete)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnClear))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtLocationId)
                                            .addComponent(txtStreetAddress)
                                            .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(92, 92, 92)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(txtStateProvince)
                            .addComponent(cbCountryId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnGetAll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(55, 55, 55)
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnGetById, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLocationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtStreetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Delete)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(btnSearch)
                    .addComponent(btnGetById))
                .addGap(18, 18, 18)
                .addComponent(btnGetAll)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Data anda akan dihapus", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_NO_OPTION) {
            JOptionPane.showMessageDialog(null, ilc.delete(txtLocationId.getText()));
            refresh();
            txtreset();
        }
        ilc.delete(txtLocationId.getText());
        refresh();
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void tblLocationAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblLocationAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblLocationAncestorAdded

    private void tblLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLocationMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblLocation.getModel();
        ListSelectionModel rowSelMod = tblLocation.getSelectionModel();

        int i = tblLocation.getSelectedRow();
        

        txtreset();
        
        txtLocationId.setText(model.getValueAt(i, 1).toString());
        txtStreetAddress.setText(model.getValueAt(i, 2).toString());
        txtPostalCode.setText(model.getValueAt(i, 3).toString());
        txtCity.setText(model.getValueAt(i, 4).toString());
        cbCountryId.setSelectedItem(model.getValueAt(i, 6).toString());
        txtStateProvince.setText(model.getValueAt(i, 5).toString());
        txtLocationId.setEditable(false);
    }//GEN-LAST:event_tblLocationMouseClicked

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblLocation.getModel();
        List<Location> location = ilc.search(txtInput.getText());

        model.setRowCount(0);
        Object[] row = new Object[7];

        for (int i = 0; i < location.size(); i++) {
            row[0] = i + 1;
            row[1] = location.get(i).getId();
            row[2] = location.get(i).getAddress();
            row[3] = location.get(i).getPostalCode();
            row[4] = location.get(i).getCity();
            row[5] = location.get(i).getStateProvince();
            row[6] = location.get(i).getCountryId();
            model.addRow(row);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllActionPerformed
        refresh();
    }//GEN-LAST:event_btnGetAllActionPerformed

    private void btnGetByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetByIdActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblLocation.getModel();
        List<Location> location = ilc.getById(txtInput.getText());

        model.setRowCount(0);
        Object[] row = new Object[7];

        for (int i = 0; i < location.size(); i++) {
            row[0] = i + 1;
            row[1] = location.get(i).getId();
            row[2] = location.get(i).getAddress();
            row[3] = location.get(i).getPostalCode();
            row[4] = location.get(i).getCity();
            row[5] = location.get(i).getStateProvince();
            row[6] = location.get(i).getCountryId();
            model.addRow(row);
        }
        
    }//GEN-LAST:event_btnGetByIdActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void cbCountryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryIdActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbCountryIdActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, ilc.save(txtLocationId.getText(), txtStreetAddress.getText(), txtPostalCode.getText(), txtCity.getText(),
            txtStateProvince.getText(), cbCountryId.getSelectedItem().toString()));
         refresh();
         txtLocationId.setEditable(true);
         txtreset();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtreset();
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnGetById;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JComboBox<String> cbCountryId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblLocation;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtLocationId;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtStateProvince;
    private javax.swing.JTextField txtStreetAddress;
    // End of variables declaration//GEN-END:variables
}
