
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

public class addClasses extends javax.swing.JFrame {
    Connection con;
    Statement st;
    ResultSet rs ;
    public addClasses() {
     
        initComponents();
        fillClass();
        fillCombo();
        doubleClick();
       
    }
  public void fillClass(){
  
  String query  =  "select * from classes_view";
  DbConnection.viewTable(query, Classes);
  
  }
  public void  fillCombo(){
      departments_com.removeAllItems();
      String  selectedItem =  "Choose Departments";
      departments_com.addItem(selectedItem);
      departments_com.setSelectedItem(selectedItem);
      
      String query = "select * from dep_view ";
      DbConnection.fillComp(query, departments_com);
  }
//   public static void  fill_class_semister_table(){
//    Connection   con =DbConnection.setConncetion();
//    String query = "select * from departments_fac_view";
//    try{
//    Statement st = con.createStatement();
//    ResultSet rs  = st.executeQuery(query);
//    dashboard.Departents_view.setModel(DbUtils.resultSetToTableModel(rs));
//    }catch(Exception e){
//    JOptionPane.showMessageDialog(null,e.getMessage());
//    }
//    
//}
   
  public boolean validateText(){
  String class_name  =  Class_txt.getText();
  int  dep_com =  departments_com.getSelectedIndex();
  if(class_name.equals("")){
  JOptionPane.showMessageDialog(null," Class name Required");
  return false;
  }
  if(dep_com == 0){
  JOptionPane.showMessageDialog(null, "Please Choose Department");
  return false;
  }
  return true;
  
  }
  
//  ====================================
  public void insert(){
  String class_name  =  Class_txt.getText();
  String   dep_com =  departments_com.getSelectedItem().toString();
  String oper  = "insert";
  String array[] = dep_com.split(" ");
  int dep_no   = Integer.parseInt(array[0]);
  String sql = "call classes_pro('"+class_name+"','"+dep_no+"','" +oper +"',null )"; 
  DbConnection.setSQL(sql);
  

  }
   public void updateClass(){
  String class_name  =  Class_txt.getText();
  String   dep_com =  departments_com.getSelectedItem().toString();
  String oper  = "update";
   TableModel dtm = (TableModel) Classes.getModel();
   int selectedRow = Classes.getSelectedRow();
   int row_no = Integer.parseInt(dtm.getValueAt(selectedRow, 0).toString());
  String array[] = dep_com.split(" ");
  int dep_no   = Integer.parseInt(array[0]);
  JOptionPane.showMessageDialog(null, row_no);
  String sql = "call classes_pro('"+class_name+"','"+dep_no+"','" +oper +"','"+row_no+"')"; 
  DbConnection.setSQL(sql);
  


  }
   public  void delteteClass(){
      int selectedRow = Classes.getSelectedRow();
   if(selectedRow == -1){
   JOptionPane.showMessageDialog(null, "Please Select  a Row To Delete First ");
   }else{
   String oper  = "delete";
   TableModel t  =  Classes.getModel();
   int id  =  Integer.parseInt(t.getValueAt(selectedRow,0).toString());
   String sql = "call classes_pro(null, null,'" +oper +"','"+id+"')";
   DbConnection.setSQL(sql);
  
   

   }
   }
  public void doubleClick(){
    
 Classes.addMouseListener(new MouseAdapter() {
     
     public void mouseClicked(MouseEvent e ){
         if(e.getClickCount() == 2){
            int selectedRow  = Classes.getSelectedRow();
//            TableModel t  = PeopleTable.getModel();
            TableModel dtm = (TableModel) Classes.getModel();
            String cl_name   =  dtm.getValueAt(selectedRow,1).toString();
            String dep_name   =  dtm.getValueAt(selectedRow,2).toString();
            String Class_id  = dtm.getValueAt(selectedRow, 0).toString();

            Class_txt.setText(cl_name);
            departments_com.addItem(dep_name);
            departments_com.setSelectedItem(dep_name);

         }
     }
 });
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Classes = new javax.swing.JTable();
        Class_txt = new RSMaterialComponent.RSTextFieldMaterial();
        departments_com = new RSMaterialComponent.RSComboBoxMaterial();
        insert = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSButtonMaterialIconOne3 = new RSMaterialComponent.RSButtonMaterialIconOne();
        rSButtonMaterialIconOne4 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Classes  =  new JTable(){
            public boolean isCellEditable(int row, int column) {
                for(int i = 0;i<Classes.getRowCount();i++){
                    if(row == i){
                        return false;
                    }

                }           return true ;
            };
        };
        Classes.setModel(new javax.swing.table.DefaultTableModel(
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
        Classes.setRowHeight(20);
        jScrollPane1.setViewportView(Classes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 410, 240));

        Class_txt.setForeground(new java.awt.Color(102, 102, 102));
        Class_txt.setCaretColor(new java.awt.Color(153, 153, 153));
        Class_txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Class_txt.setPlaceholder("Class Name");
        jPanel1.add(Class_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        departments_com.setForeground(new java.awt.Color(102, 102, 102));
        departments_com.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel1.add(departments_com, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 250, -1));

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
        jPanel1.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Departments");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 20));

        jLabel2.setBackground(new java.awt.Color(9, 121, 105));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Classes ");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 30));

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
        jPanel1.add(rSButtonMaterialIconOne3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 100, 30));

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
        jPanel1.add(rSButtonMaterialIconOne4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 100, 30));

        jButton1.setBackground(new java.awt.Color(255, 15, 64));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Class Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 420, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
 if(validateText()){
  insert();
  fillClass();
  
  }        // TODO add your handling code here:
    }//GEN-LAST:event_insertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rSButtonMaterialIconOne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne4ActionPerformed
  if(validateText()){
  updateClass();
  fillClass();
  }         // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialIconOne4ActionPerformed

    private void rSButtonMaterialIconOne3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialIconOne3ActionPerformed
  delteteClass();
  fillClass();
    }//GEN-LAST:event_rSButtonMaterialIconOne3ActionPerformed

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
            java.util.logging.Logger.getLogger(addClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addClasses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTextFieldMaterial Class_txt;
    private javax.swing.JTable Classes;
    private RSMaterialComponent.RSComboBoxMaterial departments_com;
    private RSMaterialComponent.RSButtonMaterialIconOne insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne3;
    private RSMaterialComponent.RSButtonMaterialIconOne rSButtonMaterialIconOne4;
    // End of variables declaration//GEN-END:variables
}
