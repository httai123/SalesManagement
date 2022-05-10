/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myshopmana;

import java.awt.print.PrinterException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class BillForm extends javax.swing.JFrame {

    /**
     * Creates new form BillForm
     */
    public ArrayList<Product> products = new ArrayList<>();
    public BillForm() {
        initComponents();
        //show_table();
        reloadTable();
    }
    public void reset(){
        productIDTX.setText("");
        productNameTX.setText("");
        quantityTX.setText("0");
    }
//    public void show_table(){
//        ProductForm pf = new ProductForm();
//        ArrayList<Product> products = pf.datalist();
//        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
//        Object[] row = new Object[6];
//        for(int i=0;i<products.size();i++){
//             row[0] = products.get(i).getProductID();
//            row[1] = products.get(i).getProductName();
//            row[5] = products.get(i).getProductCategory();
//            row[2] = products.get(i).getProductUnit();
//            row[3] = products.get(i).getPrice();
//            row[4] = products.get(i).getQuantity();
//            model.addRow(row);
//        }
//    }
    int newQuantity;
    String newID;
    public void update(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/salesmanager","root","");
            String query = "UPDATE products SET productQuantity="+newQuantity+""+" where productID='"+productIDTX.getText()+"'";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            reloadTable();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     public void reloadTable(){
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/salesmanager","root","");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("Select* from products");
        productTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
     public ArrayList<BillDetails> datalist(){
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        int row = productTable.getSelectedRow();
        ArrayList<BillDetails> data = new ArrayList<>();
        if(!billIDTX.getText().isEmpty()&& !productIDTX.getText().isEmpty() && !productNameTX.getText().isEmpty() && !quantityTX.getText().isEmpty()){
        double amount = Double.valueOf(TotalVND.getText());
        BillDetails billDetails = new BillDetails(billIDTX.getText(), products, amount);
        data.add(billDetails);
        }
        return data;

     }

    /**
     *
     */
    public void afterPrint(){
         ArrayList<BillDetails> billDetailses = datalist();
         try{
             Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/salesmanager","root","");
             String query2 = "insert into reports(productID,productName,price,quantitySold,total)values(?,?,?,?,?)";
             PreparedStatement pst1 = connection1.prepareStatement(query2);
             pst1.setString(1, products.get(0).getProductID());
             pst1.setString(2, products.get(0).getProductName());
             pst1.setString(3, String.valueOf(products.get(0).getPrice()));
             pst1.setString(4, String.valueOf(products.get(0).getQuantity()));
             pst1.setString(5, String.valueOf(products.get(0).getTotal()));
             for(int i = 1;i<products.size();i++){
                 for(int j=0;j<i;j++){
                 if(products.get(j).getProductID().equals(products.get(i).getProductID())){
                     String query3 = "update reports set quantitySold = "+(products.get(i).getQuantity()
                             +products.get(j).getQuantity()) + " where productID ='"+products.get(j).getProductID()+"'";
                     Statement Add = connection1.createStatement();
                     Add.executeUpdate(query3);
                 } else {
                    pst1.setString(1, products.get(i).getProductID());
                    pst1.setString(2, products.get(i).getProductName());
                    pst1.setString(3, String.valueOf(products.get(i).getPrice()));
                    pst1.setString(4, String.valueOf(products.get(i).getQuantity()));
                    pst1.setString(5, String.valueOf(products.get(i).getTotal()));
                    int executeUpdate1 = pst1.executeUpdate();
                    System.out.println("Hello");
                 }
                 }
                 
             }
             
         } catch(SQLException e){
             JOptionPane.showMessageDialog(this, e);
             e.printStackTrace();
         }
         try{
             Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost/salesmanager","root","");
             String query = "insert into billdetails(billID,billArea,amount)values(?,?,?)";
             PreparedStatement pst = connection1.prepareStatement(query);
             for(int i=0;i<billDetailses.size();i++){
                 pst.setString(1, billDetailses.get(0).getBillID());
                 pst.setString(2, billArea.getText());
                 pst.setString(3, String.valueOf(billDetailses.get(i).getAmount()));
                  int executeUpdate = pst.executeUpdate();
             }
             
         } catch(SQLException e){
             e.printStackTrace();
         }
         
    }
    public void afterAdd(){
         
         
         
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        billIDTX = new javax.swing.JTextField();
        quantityTX = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productNameTX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        productIDTX = new javax.swing.JTextField();
        cashierIDTX = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        addButton = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        reloadButton = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        CategoryTx = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        billArea = new javax.swing.JTextArea();
        printButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        TotalVND = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 224, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billIDTX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        billIDTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billIDTXActionPerformed(evt);
            }
        });
        jPanel2.add(billIDTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 180, 30));

        quantityTX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantityTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTXActionPerformed(evt);
            }
        });
        jPanel2.add(quantityTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Product quantity:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Bill ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 10));

        productNameTX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productNameTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTXActionPerformed(evt);
            }
        });
        jPanel2.add(productNameTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Date:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 20));

        productIDTX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        productIDTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIDTXActionPerformed(evt);
            }
        });
        jPanel2.add(productIDTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 30));

        cashierIDTX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cashierIDTX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashierIDTXActionPerformed(evt);
            }
        });
        jPanel2.add(cashierIDTX, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 180, 30));
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("Product name:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setText("Product ID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Cashier ID:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 310));

        jPanel6.setBackground(new java.awt.Color(224, 224, 242));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/images/deleteIcon.png"))); // NOI18N
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(deleteButton)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 70, 60));

        jPanel7.setBackground(new java.awt.Color(224, 224, 242));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/images/AddIcon.png"))); // NOI18N
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        jPanel7.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 70, 50));

        jPanel8.setBackground(new java.awt.Color(224, 224, 242));

        reloadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/images/reload.png"))); // NOI18N
        reloadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reloadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reloadButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reloadButton)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reloadButton))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 60, 50));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("<Back");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("BILL ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Filter By:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setText("REFRESH");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, 30));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "productName", "productUnit", "productPrice", "productQuantity", "category"
            }
        ));
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 450, 100));

        CategoryTx.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CategoryTx.setForeground(new java.awt.Color(24, 24, 24));
        CategoryTx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Fruits", "Fish & Shellfish", "Bread & Bakery", "Personal Care", "Vegetables", "Canned goods", "Frozen Foods", "Meat", "Sauce & Oils", "Snacks", "Beverages", "Rice", "Household", "Others" }));
        jPanel1.add(CategoryTx, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 180, 30));

        billArea.setColumns(20);
        billArea.setRows(5);
        jScrollPane2.setViewportView(billArea);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 450, 300));

        printButton.setBackground(new java.awt.Color(255, 51, 255));
        printButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printButton.setText("PRINT");
        printButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printButtonMouseEntered(evt);
            }
        });
        jPanel1.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("TOTAL:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 60, 30));

        TotalVND.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(TotalVND, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 487, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void billIDTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billIDTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_billIDTXActionPerformed

    private void quantityTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTXActionPerformed

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
       
    }//GEN-LAST:event_deleteButtonMouseClicked
int i =0;
    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(quantityTX.getText().isEmpty() || billIDTX.getText().isEmpty() || cashierIDTX.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing informations");
        }else if(availableQuantity<=Integer.valueOf(quantityTX.getText())){
            JOptionPane.showMessageDialog(this, "Not enough quantity");
        }
        else {
            newQuantity = availableQuantity - Integer.valueOf(quantityTX.getText());
            total = Uprice*Double.valueOf(quantityTX.getText());
            GrdTotal += total;
            i++;
            if(i==1){
                billArea.setText(billArea.getText()+"=========================  CIRCLE D  ==========================\n"+" CASHIER ID   "+cashierIDTX.getText()+"\n"+
                        " BILL ID    "+billIDTX.getText()+"\n"+" NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n"+"  "+i
                +"       "+productIDTX.getText()+"     "+productNameTX.getText()+"    "+Uprice+"            "+quantityTX.getText()+"            "+sdf.format(date.getDate())+"    "+total+"\n");
                
            } else{
                billArea.setText(billArea.getText()+"  "+i
                +"       "+productIDTX.getText()+"     "+productNameTX.getText()+"    "+Uprice+"            "+quantityTX.getText()+"            "+sdf.format(date.getDate())+"    "+total+"\n");
            }
            TotalVND.setText(GrdTotal+"");
            update();
            Product product = new Product(productIDTX.getText(),productNameTX.getText(),unit,cate,Uprice,Integer.valueOf(quantityTX.getText()));
            products.add(product);
            System.out.println(newQuantity);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void reloadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reloadButtonMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_reloadButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        ManagerForm managerForm = new ManagerForm();
        managerForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonMouseClicked

    private void productNameTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTXActionPerformed

    private void productIDTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIDTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIDTXActionPerformed

    private void cashierIDTXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashierIDTXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashierIDTXActionPerformed
    Double Uprice,total=0.0,GrdTotal=0.0;
    int availableQuantity;
    String unit,cate;
    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        int row = productTable.getSelectedRow();
        Uprice = Double.valueOf(model.getValueAt(row, 3).toString());
        productIDTX.setText(model.getValueAt(row, 0).toString());
        productNameTX.setText(model.getValueAt(row, 1).toString());
        availableQuantity = Integer.valueOf(model.getValueAt(row, 4).toString());
        newID = model.getValueAt(row, 1).toString();
        unit = model.getValueAt(row, 2).toString();
        cate = model.getValueAt(row, 5).toString();
//        System.out.println(Uprice);
        
    }//GEN-LAST:event_productTableMouseClicked

    private void printButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_printButtonMouseEntered

    private void printButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printButtonMouseClicked
        afterPrint();
        try {
            // TODO add your handling code here:
            billArea.print();
            
        } catch (PrinterException ex) {
            Logger.getLogger(BillForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printButtonMouseClicked

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
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoryTx;
    private javax.swing.JLabel TotalVND;
    private javax.swing.JLabel addButton;
    private javax.swing.JLabel backButton;
    private javax.swing.JTextArea billArea;
    private javax.swing.JTextField billIDTX;
    private javax.swing.JTextField cashierIDTX;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton printButton;
    private javax.swing.JTextField productIDTX;
    private javax.swing.JTextField productNameTX;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityTX;
    private javax.swing.JLabel reloadButton;
    // End of variables declaration//GEN-END:variables
}
