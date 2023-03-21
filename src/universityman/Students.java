
package universityman;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Students extends javax.swing.JFrame {
    Connection con;
    Statement st;
    ResultSet rs ;
    public Students() {
     
        initComponents();
        fillStudent();
        fillPeopleCombo();
        fillRespeCombo();
        fillBat_com();
        fillSchoolCom();
        doubleClick();
        
       
    }
  public static  void fillStudentForDash(){
  
  String query  =  "select * from registeredStudents_view";
  DbConnection.viewTable(query, dash.student_table);
  
  
  }
    public static  void fillStudent(){
  
  String query  =  "select * from registeredStudents_view";
  DbConnection.viewTable(query, student_table);
  
  
  }
  public void  fillPeopleCombo(){
      people_com.removeAllItems();
      String  selectedItem =  "Choose People";
      people_com.addItem(selectedItem);
      people_com.setSelectedItem(selectedItem);
      
      String query = "select * from fillPeopleCom ";
      DbConnection.fillComp(query, people_com);
  }
  public void  fillRespeCombo(){
      resp_com.removeAllItems();
      String  selectedItem =  "Choose Responsible Person";
      resp_com.addItem(selectedItem);
      resp_com.setSelectedItem(selectedItem);
      
      String query = "select * from fillResp_com ";
      DbConnection.fillComp(query, resp_com);
  }
    public void  fillSchoolCom(){
      schl_com.removeAllItems();
      String  selectedItem =  "Choose  School";
      schl_com.addItem(selectedItem);
      schl_com.setSelectedItem(selectedItem);
      
      String query = "select * from fillSchoolCom ";
      DbConnection.fillComp(query, schl_com);
  }
   public void  fillBat_com(){
      bat_com.removeAllItems();
      String  selectedItem =  "Choose  Batches";
      bat_com.addItem(selectedItem);
      bat_com.setSelectedItem(selectedItem);
      
      String query = "select * from fillBat_com ";
      DbConnection.fillComp(query, bat_com);
  }
   public static void  fill_class_semister_table(){
    Connection   con =DbConnection.setConncetion();
    String query = "select * from departments_fac_view";
    try{
    Statement st = con.createStatement();
    ResultSet rs  = st.executeQuery(query);
    dash.student_table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
    JOptionPane.showMessageDialog(null,e.getMessage());
    }
    
}
   
  public boolean validateText(){
  String Mother  =  mother.getText();
  int  dep_com =  people_com.getSelectedIndex();
  if(people_com.getSelectedIndex() ==  0){
  JOptionPane.showMessageDialog(null, "Need Student Name ");
  return false; 
  }
  if(resp_com.getSelectedIndex() ==  0){
  JOptionPane.showMessageDialog(null, "Responsible Person Requited ");
  return false; 
  }
  if(schl_com.getSelectedIndex() ==  0){
  JOptionPane.showMessageDialog(null, "Need School Of the Student  ");
  return false; 
  }
  if(status.getSelectedIndex() ==  0){
  JOptionPane.showMessageDialog(null, "Need Status Of The Student  ");
  return false; 
  }
  if(Mother.equals("")){
  JOptionPane.showMessageDialog(null, "Need Student's Mother Name  ");
  return false; 
  }
  if(bat_com.getSelectedIndex() == 0){
  JOptionPane.showMessageDialog(null," Please Specify The Batch ");
  return false;
  }
 
  return true;
  
  }
  
//  ====================================
  public void insert(){
    String oper  = "insert";
//  String class_name  =  Class_txt.getText();
  String  p_name  =  people_com.getSelectedItem().toString();
  String array[] = p_name.split(" ");
  int p_no   = Integer.parseInt(array[0]);
  
  String  resp_name  =  resp_com.getSelectedItem().toString();
  String array_res[] = resp_name.split(" ");
  int resp_no   = Integer.parseInt(array_res[0]);
  
   String  scl_name  =  schl_com.getSelectedItem().toString();
  String array_scl[] = scl_name.split(" ");
  int scl_no   = Integer.parseInt(array_scl[0]);
  
 String  status_name  =  status.getSelectedItem().toString();
   String  mother_name  =  mother.getText();
   
    String  bat_name  =  bat_com.getSelectedItem().toString();
  String array_bat[] = bat_name.split(" ");
  int bat_no   = Integer.parseInt(array_bat[0]);

  
     
  String sql = "call student_pro('"+p_no+"','"+resp_no+"','"+scl_no+"','"+status_name+"','"+mother_name+"','"+bat_no+"','" +oper +"',null )"; 
  DbConnection.setSQL(sql);
    fillStudent();
  

  }
   public void updateStudent(){
    String oper  = "update";
      TableModel dtm = (TableModel) student_table.getModel();
   int selectedRow = student_table.getSelectedRow();
   int id_no  = Integer.parseInt(dtm.getValueAt(selectedRow, 0).toString());
   
//  String class_name  =  Class_txt.getText();
  String  p_name  =  people_com.getSelectedItem().toString();
  String array[] = p_name.split(" ");
  int p_no   = Integer.parseInt(array[0]);
  
  String  resp_name  =  resp_com.getSelectedItem().toString();
  String array_res[] = resp_name.split(" ");
  int resp_no   = Integer.parseInt(array_res[0]);
  
   String  scl_name  =  schl_com.getSelectedItem().toString();
  String array_scl[] = scl_name.split(" ");
  int scl_no   = Integer.parseInt(array_scl[0]);
  
 String  status_name  =  status.getSelectedItem().toString();
   String  mother_name  =  mother.getText();
   
    String  bat_name  =  bat_com.getSelectedItem().toString();
  String array_bat[] = bat_name.split(" ");
  int bat_no   = Integer.parseInt(array_bat[0]);

  
     
  String sql = "call student_pro('"+p_no+"','"+resp_no+"','"+scl_no+"','"+status_name+"','"+mother_name+"','"+bat_no+"','" +oper +"','" +id_no +"')"; 
  DbConnection.setSQL(sql);
   
  

  }
   public  void delteteClass(){
      int selectedRow = student_table.getSelectedRow();
   if(selectedRow == -1){
   JOptionPane.showMessageDialog(null, "Please Select  a Row To Delete First ");
   }else{
   String oper  = "delete";
   TableModel t  =  student_table.getModel();
   int id  =  Integer.parseInt(t.getValueAt(selectedRow,0).toString());
   String sql = "call student_pro(null, null,null,null,null,null,'" +oper +"','"+id+"')";
   DbConnection.setSQL(sql);
    
   

   }
   }
  public void doubleClick(){
    
 student_table.addMouseListener(new MouseAdapter() {
     
     public void mouseClicked(MouseEvent e ){
         if(e.getClickCount() == 2){
            int selectedRow  = student_table.getSelectedRow();
//            TableModel t  = PeopleTable.getModel();
            TableModel dtm = (TableModel) student_table.getModel();
            String p_no = dtm.getValueAt(selectedRow, 1).toString();
            String resp_no = dtm.getValueAt(selectedRow, 2).toString();
            String status_value = dtm.getValueAt(selectedRow, 5).toString();
            
            String scl_no = dtm.getValueAt(selectedRow, 3).toString();
            String mother_no = dtm.getValueAt(selectedRow, 5).toString();
            String bat_no = dtm.getValueAt(selectedRow,6).toString();
//            JOptionPane.showMessageDialog(null, p_no);

//            String cl_name   =  dtm.getValueAt(selectedRow,1).toString();
//            String dep_name   =  dtm.getValueAt(selectedRow,2).toString();
//            String Class_id  = dtm.getValueAt(selectedRow, 0).toString();

            
            people_com.addItem(p_no);
            people_com.setSelectedItem(p_no);
            
            resp_com.addItem(resp_no);
            resp_com.setSelectedItem(resp_no);
            schl_com.addItem(scl_no);
            schl_com.setSelectedItem(scl_no);
            
            status.addItem(status_value);
            status.setSelectedItem(status_value);
            
            mother.setText(mother_no);
            
            bat_com.addItem(bat_no);
            bat_com.setSelectedItem(bat_no);
            


         }
     }
 });
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        mother = new RSMaterialComponent.RSTextFieldMaterial();
        people_com = new RSMaterialComponent.RSComboBoxMaterial();
        insert = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMaterialIconOne3 = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSButtonMaterialIconOne4 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        status = new RSMaterialComponent.RSComboBoxMaterial();
        bat_com = new RSMaterialComponent.RSComboBoxMaterial();
        schl_com = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        resp_com = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Class_txt1 = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_table  =  new JTable(){
            public boolean isCellEditable(int row, int column) {
                for(int i = 0;i<student_table.getRowCount();i++){
                    if(row == i){
                        return false;
                    }

                }           return true ;
            };
        };
        student_table.setModel(new javax.swing.table.DefaultTableModel(
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
        student_table.setRowHeight(20);
        jScrollPane1.setViewportView(student_table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 980, 200));

        mother.setForeground(new java.awt.Color(102, 102, 102));
        mother.setCaretColor(new java.awt.Color(153, 153, 153));
        mother.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mother.setPlaceholder("Mother Name");
        jPanel1.add(mother, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 250, 40));

        people_com.setForeground(new java.awt.Color(102, 102, 102));
        people_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        people_com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                people_comActionPerformed(evt);
            }
        });
        jPanel1.add(people_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 250, -1));

        insert.setBackground(new java.awt.Color(51, 87, 197));
        insert.setText("Insert");
        insert.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        insert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insert.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel1.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Batch");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 90, 20));

        jLabel2.setBackground(new java.awt.Color(9, 121, 105));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 970, 30));

        rSButtonMaterialIconOne3.setBackground(new java.awt.Color(255, 15, 64));
        rSButtonMaterialIconOne3.setText("Delete");
        rSButtonMaterialIconOne3.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        rSButtonMaterialIconOne3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        rSButtonMaterialIconOne3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 100, 30));

        rSButtonMaterialIconOne4.setBackground(new java.awt.Color(102, 188, 101));
        rSButtonMaterialIconOne4.setText("Update");
        rSButtonMaterialIconOne4.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        rSButtonMaterialIconOne4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rSButtonMaterialIconOne4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        rSButtonMaterialIconOne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialIconOne4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialIconOne4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 100, 30));

        jButton1.setBackground(new java.awt.Color(255, 15, 64));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Student Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 120, 20));

        status.setForeground(new java.awt.Color(102, 102, 102));
        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Status", "Active", "InActive" }));
        status.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 250, -1));

        bat_com.setForeground(new java.awt.Color(102, 102, 102));
        bat_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(bat_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 250, -1));

        schl_com.setForeground(new java.awt.Color(102, 102, 102));
        schl_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        schl_com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schl_comActionPerformed(evt);
            }
        });
        jPanel1.add(schl_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 250, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("School");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("responsible");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 20));

        resp_com.setForeground(new java.awt.Color(102, 102, 102));
        resp_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        resp_com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resp_comActionPerformed(evt);
            }
        });
        jPanel1.add(resp_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 250, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Mother");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Status ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 90, 20));

        Class_txt1.setForeground(new java.awt.Color(102, 102, 102));
        Class_txt1.setCaretColor(new java.awt.Color(153, 153, 153));
        Class_txt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Class_txt1.setPlaceholder("Class Name");
        jPanel1.add(Class_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 110, 30));

        jLabel8.setBackground(new java.awt.Color(9, 121, 105));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manage Students ");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 990, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
 if(validateText()){
  insert();
  fillStudent();
  
  }        // TODO add your handling code here:
    }//GEN-LAST:event_insertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSButtonMaterialIconOne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne4ActionPerformed
  if(validateText()){
  updateStudent();
  fillStudent();
  }         // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne4ActionPerformed

    private void rSButtonMaterialIconOne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne3ActionPerformed
  delteteClass();
  fillStudent();
    }//GEN-LAST:event_rSButtonMaterialIconOne3ActionPerformed

    private void people_comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_people_comActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_people_comActionPerformed

    private void resp_comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resp_comActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resp_comActionPerformed

    private void schl_comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schl_comActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schl_comActionPerformed

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
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Students.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTextFieldMaterial Class_txt1;
    private RSMaterialComponent.RSComboBoxMaterial bat_com;
    private RSMaterialComponent.RSButtonMaterialIconOne insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSTextFieldMaterial mother;
    private RSMaterialComponent.RSComboBoxMaterial people_com;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne3;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne4;
    private RSMaterialComponent.RSComboBoxMaterial resp_com;
    private RSMaterialComponent.RSComboBoxMaterial schl_com;
    private RSMaterialComponent.RSComboBoxMaterial status;
    public static javax.swing.JTable student_table;
    // End of variables declaration//GEN-END:variables
}
